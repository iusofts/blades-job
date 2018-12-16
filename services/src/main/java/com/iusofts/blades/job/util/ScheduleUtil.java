package com.iusofts.blades.job.util;

import com.iusofts.blades.job.constant.JobConstant;
import com.iusofts.blades.job.enums.JobExceptionEnum;
import com.iusofts.blades.job.exceptions.ScheduleException;
import com.iusofts.blades.job.common.util.JsonUtils;
import com.iusofts.blades.job.enums.JobLevel;
import com.iusofts.blades.job.model.ScheduleJob;
import com.iusofts.blades.job.quartz.AsyncJobFactory;
import com.iusofts.blades.job.quartz.SyncJobFactory;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 定时任务操作辅助类
 */
public class ScheduleUtil {

	/** 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleUtil.class);

	/**
	 * 获取触发器key
	 *
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
	public static TriggerKey getTriggerKey(String jobName, String jobGroup) {
		return TriggerKey.triggerKey(jobName, jobGroup);
	}

	/**
	 * 获取表达式触发器
	 *
	 * @param scheduler
	 *            the scheduler
	 * @param jobName
	 *            the job name
	 * @param jobGroup
	 *            the job group
	 * @return cron trigger
	 */
	public static CronTrigger getCronTrigger(Scheduler scheduler, String jobName, String jobGroup) {

		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			return (CronTrigger) scheduler.getTrigger(triggerKey);
		} catch (SchedulerException e) {
			LOG.error("获取定时任务CronTrigger出现异常", e);
			throw new ScheduleException("获取定时任务CronTrigger出现异常");
		}
	}

	/**
	 * 创建主任务
	 *
	 * @param scheduler
	 *            the scheduler
	 * @param scheduleJob
	 *            the schedule job
	 */
	public static void createScheduleJob(Scheduler scheduler, ScheduleJob scheduleJob) {
		createScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(),JobLevel.MASTER,
				scheduleJob.getCronExpression(), scheduleJob.getIsSync() == 1, scheduleJob);
	}

	/**
	 * 创建子任务
	 *
	 * @param scheduler
	 *            the scheduler
	 * @param scheduleJob
	 *            the schedule job
	 */
	public static void createChildJob(Scheduler scheduler, ScheduleJob scheduleJob) {
		createScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(),JobLevel.CHILD,
				scheduleJob.getCronExpression(), scheduleJob.getIsSync() == 1, scheduleJob);
	}


	/**
	 * 创建定时任务
	 *
	 * @param scheduler
	 *            the scheduler
	 * @param jobName
	 *            the job name
	 * @param jobGroup
	 *            the job group
	 * @param cronExpression
	 *            the cron expression
	 * @param isSync
	 *            the is sync
	 * @param param
	 *            the param
	 */
	public static void createScheduleJob(Scheduler scheduler, String jobName, String jobGroup, JobLevel jobLevel, String cronExpression,
										 boolean isSync, Object param) {
		try {
			if(jobLevel == JobLevel.CHILD){//子任务添加前缀
				jobName = JobConstant.CHILD_JOB_PREFIX + jobName;
			}
			// 判断是否已存在
			if (checkExists(scheduler, jobName, jobGroup)) {
				LOG.error("===> AddJob fail, job already exist, jobGroup:{}, jobName:{}", jobGroup, jobName);
				throw new ScheduleException(JobExceptionEnum.ALREADY_EXIST.getCode(),
						String.format("Job已经存在, jobName:{%s},jobGroup:{%s}", jobName, jobGroup));
			}

			// 同步或异步
			Class<? extends Job> jobClass = isSync ? AsyncJobFactory.class : SyncJobFactory.class;

			// 构建job信息
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();

			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

			// 按新的cronExpression表达式构建一个新的trigger
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
					.withSchedule(scheduleBuilder).build();

			String jobTrigger = trigger.getKey().getName();

			ScheduleJob scheduleJob = (ScheduleJob) param;
			scheduleJob.setJobTrigger(jobTrigger);

			// 放入参数，运行时的方法可以获取
			jobDetail.getJobDataMap().put(JobConstant.JOB_PARAM_KEY, JsonUtils.obj2json(scheduleJob));// 改成json字符串防止反序列化报错
			jobDetail.getJobDataMap().put(JobConstant.JOB_LEVEL_KEY, jobLevel.getCode());

			Date computeFirstFireTime = scheduler.scheduleJob(jobDetail, trigger);
			scheduleJob.setNextFireTime(computeFirstFireTime.getTime());
		} catch (SchedulerException e) {
			LOG.error("创建定时任务失败/执行表达式错误", e);
			throw new ScheduleException("创建定时任务失败/执行表达式错误");
		}
	}

	/**
	 * 运行一次任务
	 *
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void runOnce(Scheduler scheduler, String jobName, String jobGroup) {
		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		try {
			scheduler.triggerJob(jobKey);
		} catch (SchedulerException e) {
			LOG.error("运行一次定时任务失败", e);
			throw new ScheduleException("运行一次定时任务失败");
		}
	}

	/**
	 * 暂停任务
	 *
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) {

		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		JobKey childJobKey = JobKey.jobKey(JobConstant.CHILD_JOB_PREFIX + jobName, jobGroup);
		try {
			scheduler.pauseJob(jobKey);
			LOG.info("===> Pause master job success, jobKey:{}", jobKey);
			scheduler.pauseJob(childJobKey);
			LOG.info("===> Pause child job success, jobKey:{}", childJobKey);
		} catch (SchedulerException e) {
			LOG.error("暂停定时任务失败", e);
			throw new ScheduleException("暂停定时任务失败");
		}
	}

	/**
	 * 恢复任务
	 *
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) {

		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		JobKey childJobKey = JobKey.jobKey(JobConstant.CHILD_JOB_PREFIX + jobName, jobGroup);
		try {
			scheduler.resumeJob(jobKey);
			LOG.info("===> Resume master job success, jobKey:{}", jobKey);
			scheduler.resumeJob(childJobKey);
			LOG.info("===> Resume child job success, jobKey:{}", childJobKey);
		} catch (SchedulerException e) {
			LOG.error("暂停定时任务失败", e);
			throw new ScheduleException("暂停定时任务失败");
		}
	}

	/**
	 * 获取jobKey
	 *
	 * @param jobName
	 *            the job name
	 * @param jobGroup
	 *            the job group
	 * @return the job key
	 */
	public static JobKey getJobKey(String jobName, String jobGroup) {

		return JobKey.jobKey(jobName, jobGroup);
	}

	/**
	 * 更新定时任务
	 *
	 * @param scheduler
	 *            the scheduler
	 * @param scheduleJob
	 *            the schedule job
	 */
	public static void updateScheduleJob(Scheduler scheduler, ScheduleJob scheduleJob) {
		updateScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(),
				scheduleJob.getCronExpression(), scheduleJob.getIsSync() != null ? scheduleJob.getIsSync() == 1 : false,
				scheduleJob);
	}

	/**
	 * 更新定时任务
	 *
	 * @param scheduler
	 *            the scheduler
	 * @param jobName
	 *            the job name
	 * @param jobGroup
	 *            the job group
	 * @param cronExpression
	 *            the cron expression
	 * @param isSync
	 *            the is sync
	 * @param param
	 *            the param
	 */
	public static void updateScheduleJob(Scheduler scheduler, String jobName, String jobGroup, String cronExpression,
			boolean isSync, Object param) {

		// 同步或异步
		// Class<? extends Job> jobClass = isSync ? AsyncJobFactory.class :
		// SyncJobFactory.class;

		try {
			// JobDetail jobDetail = scheduler.getJobDetail(getJobKey(jobName,
			// jobGroup));

			// jobDetail = jobDetail.getJobBuilder().ofType(jobClass).build();

			// 更新参数 实际测试中发现无法更新
			// JobDataMap jobDataMap = jobDetail.getJobDataMap();
			// jobDataMap.put(ScheduleJobVo.JOB_PARAM_KEY, param);
			// jobDetail.getJobBuilder().usingJobData(jobDataMap);

			if (!checkExists(scheduler, jobName, jobGroup)) {
				throw new ScheduleException(String.format("Job不存在, jobName:{%s},jobGroup:{%s}", jobName, jobGroup));
			}

			TriggerKey triggerKey = ScheduleUtil.getTriggerKey(jobName, jobGroup);

			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			// 忽略状态为PAUSED的任务，解决集群环境中在其他机器设置定时任务为PAUSED状态后，集群环境启动另一台主机时定时任务全被唤醒的bug
			if (!triggerState.name().equalsIgnoreCase("PAUSED")) {
				// 按新的trigger重新设置job执行
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		} catch (SchedulerException e) {
			LOG.error("更新定时任务失败/执行表达式错误", e);
			throw new ScheduleException("更新定时任务失败/执行表达式错误");
		}
	}

	/**
	 * 删除主定时任务
	 *
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void deleteScheduleJob(Scheduler scheduler, String jobName, String jobGroup) {
		try {
			scheduler.deleteJob(getJobKey(jobName, jobGroup));
			LOG.info("===> delete master job, jobName:{},jobGroup:{}", jobName, jobGroup);
			deleteChildJob(scheduler, jobName, jobGroup);
		} catch (SchedulerException e) {
			LOG.error("删除定时任务失败", e);
			throw new ScheduleException("删除定时任务失败");
		}
	}

	/**
	 * 删除子定时任务
	 *
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void deleteChildJob(Scheduler scheduler, String jobName, String jobGroup) {
		try {
			scheduler.deleteJob(getJobKey(JobConstant.CHILD_JOB_PREFIX + jobName, jobGroup));
			LOG.info("===> delete child job, jobName:{},jobGroup:{}", JobConstant.CHILD_JOB_PREFIX + jobName, jobGroup);
		} catch (SchedulerException e) {
			LOG.error("删除子定时任务失败", e);
			throw new ScheduleException("删除子定时任务失败");
		}
	}

	/**
	 * 验证是否存在
	 *
	 * @param jobName
	 * @param jobGroup
	 * @throws SchedulerException
	 */
	private static boolean checkExists(Scheduler scheduler, String jobName, String jobGroup) throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
		return scheduler.checkExists(triggerKey);
	}

}
