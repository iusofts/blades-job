package com.iusofts.blades.job.service;

import com.iusofts.blades.job.common.page.PagingResult;
import com.iusofts.blades.job.common.util.ModelMapperUtil;
import com.iusofts.blades.job.dao.ScheduleJobDao;
import com.iusofts.blades.job.enums.*;
import com.iusofts.blades.job.exceptions.ScheduleException;
import com.iusofts.blades.job.interfaces.ScheduleJobInterface;
import com.iusofts.blades.job.model.ScheduleJob;
import com.iusofts.blades.job.model.ScheduleJobExample;
import com.iusofts.blades.job.util.ScheduleJobExecuteUtil;
import com.iusofts.blades.job.util.ScheduleUtil;
import com.iusofts.blades.job.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 定时任务服务
 */
@Service
public class ScheduleJobService implements ScheduleJobInterface {

	/** 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleUtil.class);

	/** 调度工厂Bean */
	@Autowired
	private Scheduler scheduler;

	@Autowired
	private ScheduleJobDao scheduleJobDao;

	@Transactional
	public Long addRepeatJob(AddRepeatJobParamVo paramVo) {
		// 判断任务是否存在
		ScheduleJob scheduleJob = getScheduleJobByJobkey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJob == null) {
			scheduleJob = ModelMapperUtil.strictMap(paramVo, ScheduleJob.class);
			// 分析任务类型
			JobType jobType = analysisJobType(paramVo.getCronExpression());
			scheduleJob.setJobType(jobType.getCode());
			// 插入数据库
			scheduleJobDao.insertSelective(scheduleJob);
			// 创建任务
			ScheduleUtil.createScheduleJob(scheduler, scheduleJob);
			// 更新下次执行时间
			scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);
			return scheduleJob.getId();
		} else {
			throw new ScheduleException(JobExceptionEnum.ALREADY_EXIST.getCode(), "任务已存在");
		}
	}

	@Override
	public Long addOnceJob(AddOnceJobParamVo paramVo) {
		// 判断任务是否存在
		ScheduleJob scheduleJob = getScheduleJobByJobkey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJob == null) {
			scheduleJob = ModelMapperUtil.strictMap(paramVo, ScheduleJob.class);
			// 时间转成cron表达式格式
			String cronExpression = ScheduleJobExecuteUtil.executeTimeToCronExperssion(paramVo.getExecuteTime());

			scheduleJob.setCronExpression(cronExpression);
			scheduleJob.setJobType(JobType.ONCE.getCode());
			scheduleJob.setNextFireTime(paramVo.getExecuteTime().getTime());

			// 插入数据库
			scheduleJobDao.insertSelective(scheduleJob);
			// 创建任务
			ScheduleUtil.createScheduleJob(scheduler, scheduleJob);
			// 更新下次执行时间
			scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);
			return scheduleJob.getId();
		} else {
			throw new ScheduleException(JobExceptionEnum.ALREADY_EXIST.getCode(), "任务已存在");
		}
	}

	@Override
	public Long recreateRepeatJob(AddRepeatJobParamVo paramVo) {
		// 判断任务是否存在 已存在更新 不存在则创建
		ScheduleJob scheduleJob = getScheduleJobByJobkey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJob != null) {
			BeanUtils.copyProperties(paramVo,scheduleJob);
			scheduleJob.setStatus(JobStatus.NORMAL.getCode());
			scheduleJob.setJobType(JobType.REPEAT.getCode());
			scheduleJob.setRetryStatus(JobRetryStatus.NO_RETRY.getCode());
			scheduleJob.setRetriedNum(0);
			// 分析任务类型
			JobType jobType = analysisJobType(paramVo.getCronExpression());
			scheduleJob.setJobType(jobType.getCode());

			// 先删除
			ScheduleUtil.deleteScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
			// 再创建
			ScheduleUtil.createScheduleJob(scheduler, scheduleJob);

			// 更新数据库
			scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);

			return scheduleJob.getId();
		} else {
			return addRepeatJob(paramVo);
		}
	}

	@Override
	public Long recreateOnceJob(AddOnceJobParamVo paramVo) {
		// 判断任务是否存在 已存在更新 不存在则创建
		ScheduleJob scheduleJob = getScheduleJobByJobkey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJob != null) {
			BeanUtils.copyProperties(paramVo,scheduleJob);
			scheduleJob.setId(scheduleJob.getId());
			scheduleJob.setJobType(JobType.ONCE.getCode());
			scheduleJob.setStatus(JobStatus.NORMAL.getCode());
			scheduleJob.setRetryStatus(JobRetryStatus.NO_RETRY.getCode());
			scheduleJob.setRetriedNum(0);
			// 时间转成cron表达式格式
			String cronExpression = ScheduleJobExecuteUtil.executeTimeToCronExperssion(paramVo.getExecuteTime());
			scheduleJob.setCronExpression(cronExpression);

			// 先删除
			ScheduleUtil.deleteScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
			// 再创建
			ScheduleUtil.createScheduleJob(scheduler, scheduleJob);

			// 更新数据库
			scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);

			return scheduleJob.getId();
		} else {
			return addOnceJob(paramVo);
		}
	}

	@Override
	public void update(ScheduleJob scheduleJob) {
		this.scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);
	}

	@Override
	public void remove(Long scheduleJobId) {
		ScheduleJob scheduleJob = scheduleJobDao.selectByPrimaryKey(scheduleJobId);
		// 删除运行的任务
		ScheduleUtil.deleteScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
		// 删除数据(软删除)
		scheduleJob.setDeleteFlag(DelFlagEnum.DELETED.getCode());
		scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);
	}

	@Override
	public void runOnce(Long scheduleJobId) {
		ScheduleJob scheduleJob = scheduleJobDao.selectByPrimaryKey(scheduleJobId);
		//ScheduleUtil.runOnce(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
		ScheduleJobExecuteUtil.executeScheduleJob(scheduleJob, JobLevel.MASTER);
	}

	@Override
	public void pauseJob(Long scheduleJobId) {
		ScheduleJob scheduleJob = scheduleJobDao.selectByPrimaryKey(scheduleJobId);
		if(scheduleJob.getStatus().intValue() == JobStatus.NORMAL.getCode()){
			pauseJob(scheduleJob);
		} else if(scheduleJob.getStatus().intValue() == JobStatus.ERROR.getCode()){
			// 出错任务有下一次执行时间，也需要暂停
			if (scheduleJob.getNextFireTime() > new Date().getTime()) {
				pauseJob(scheduleJob);
			} else {
				throw new ScheduleException("任务已结束无法暂停");
			}
		} else {
			throw new ScheduleException("任务已结束无法暂停");
		}
	}

	/**
	 * 暂停任务
	 * @param scheduleJob
	 */
	private void pauseJob(ScheduleJob scheduleJob) {
		ScheduleUtil.pauseJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
		// 更新数据库
		scheduleJob.setStatus(JobStatus.PAUSED.getCode());
		scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);
	}

	@Override
	public void resumeJob(Long scheduleJobId) {
		ScheduleJob scheduleJob = scheduleJobDao.selectByPrimaryKey(scheduleJobId);
		if (scheduleJob.getStatus().intValue() == JobStatus.PAUSED.getCode()) {
			ScheduleUtil.resumeJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
			// 更新数据库
			scheduleJob.setStatus(JobStatus.NORMAL.getCode());
			scheduleJobDao.updateByPrimaryKeySelective(scheduleJob);
		} else {
			throw new ScheduleException("任务未暂停无法恢复");
		}
	}

	@Override
	public ScheduleJob get(Long scheduleJobId) {
		return scheduleJobDao.selectByPrimaryKey(scheduleJobId);
	}

	@Override
	public ScheduleJobVo getDetail(Long scheduleJobId) {
		ScheduleJob scheduleJob = scheduleJobDao.selectByPrimaryKey(scheduleJobId);
		return ModelMapperUtil.strictMap(scheduleJob, ScheduleJobVo.class);
	}

	@Override
	public ScheduleJobVo getByKey(String jobName, String jobGroup) {
		ScheduleJob scheduleJob = getScheduleJobByJobkey(jobName, jobGroup);
		if (scheduleJob != null) {
			return ModelMapperUtil.strictMap(scheduleJob, ScheduleJobVo.class);
		}
		return null;
	}

	@Override
	public PagingResult<ScheduleJobVo> queryList(QueryScheduleJobParamVo paramVo) {
		PagingResult<ScheduleJobVo> pagingResult = new PagingResult<>();
		ScheduleJobExample example = new ScheduleJobExample();
		ScheduleJobExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteFlagEqualTo(DelFlagEnum.UN_DELETED.getCode());//未删除
		if(StringUtils.isNotBlank(paramVo.getJobName())){
			criteria.andJobNameEqualTo(paramVo.getJobName());
		}
		if(StringUtils.isNotBlank(paramVo.getJobGroup())){
			criteria.andJobGroupEqualTo(paramVo.getJobGroup());
		}
		if(paramVo.getStatus()!=null && paramVo.getStatus()>0){
			criteria.andStatusEqualTo(paramVo.getStatus());
		}
		if(StringUtils.isNotBlank(paramVo.getSysCode())){
			criteria.andSysCodeEqualTo(paramVo.getSysCode());
		}
		if(paramVo.getId()!=null && paramVo.getId()>0){
			criteria.andIdEqualTo(paramVo.getId());
		}

		pagingResult.setTotalCount(this.scheduleJobDao.countByExample(example));
		pagingResult.setTotalPage(pagingResult.getTotalCount() / paramVo.getPagination().getPageSize());

		example.setLimitStart((paramVo.getPagination().getCurrentPage() - 1) * paramVo.getPagination().getPageSize());
		example.setLimitSize(paramVo.getPagination().getPageSize());
		example.setOrderByClause("create_time desc");

		List<ScheduleJob> scheduleJobs = scheduleJobDao.selectByExample(example);

		List<ScheduleJobVo> scheduleJobVoList = ModelMapperUtil.strictMapList(scheduleJobs, ScheduleJobVo.class);
		try {
			for (ScheduleJobVo vo : scheduleJobVoList) {

				JobKey jobKey = ScheduleUtil.getJobKey(vo.getJobName(), vo.getJobGroup());
				List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
				if (CollectionUtils.isEmpty(triggers)) {
					continue;
				}

				// 这里一个任务可以有多个触发器， 但是我们一个任务对应一个触发器，所以只取第一个即可，清晰明了
				Trigger trigger = triggers.iterator().next();
				vo.setJobTrigger(trigger.getKey().getName());

				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				vo.setTriggerStatus(triggerState.ordinal());

			}
		} catch (SchedulerException e) {
			LOG.error("query trigger state error", e);
		}
		pagingResult.setDataList(scheduleJobVoList);
		return pagingResult;
	}

	@Override
	public int count(CountScheduleJobParamVo paramVo) {
		ScheduleJobExample example = new ScheduleJobExample();
		ScheduleJobExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteFlagEqualTo(DelFlagEnum.UN_DELETED.getCode());
		if(StringUtils.isNotBlank(paramVo.getSysCode())){
			criteria.andSysCodeEqualTo(paramVo.getSysCode());
		}
		if(StringUtils.isNotBlank(paramVo.getJobName())){
			criteria.andJobNameEqualTo(paramVo.getJobName());
		}
		if(StringUtils.isNotBlank(paramVo.getJobGroup())){
			criteria.andJobGroupEqualTo(paramVo.getJobGroup());
		}
		if (paramVo.getStatus() != null) {
			if(paramVo.getStatus() == JobStatus.RETRY.getCode()){ // 重试状态
				criteria.andStatusEqualTo(JobStatus.ERROR.getCode()).andRetryStatusEqualTo(JobRetryStatus.RETRYING.getCode());
			} else {
				criteria.andStatusEqualTo(paramVo.getStatus());
			}
		}
		return this.scheduleJobDao.countByExample(example);
	}

	@Override
	public void initScheduleJob() {
		List<ScheduleJob> scheduleJobList = scheduleJobDao.selectByExample(new ScheduleJobExample());
		if (CollectionUtils.isEmpty(scheduleJobList)) {
			return;
		}
		for (ScheduleJob scheduleJob : scheduleJobList) {

			CronTrigger cronTrigger = ScheduleUtil.getCronTrigger(scheduler, scheduleJob.getJobName(),
					scheduleJob.getJobGroup());

			// 不存在，创建一个
			if (cronTrigger == null) {
				ScheduleUtil.createScheduleJob(scheduler, scheduleJob);
			} else {
				// 已存在，那么更新相应的定时设置
				ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);
			}
		}
	}

	/**
	 * 判断任务类型(根据占位符和长度判断)
	 *
	 * @param cronExpression
	 * @return
	 */
	private JobType analysisJobType(String cronExpression) {
		if (cronExpression.indexOf("*") == -1 && cronExpression.indexOf(",") == -1 && cronExpression.indexOf("-") == -1
				&& cronExpression.indexOf("/") == -1 && cronExpression.split(" ").length == 7) {
			return JobType.ONCE;
		}
		return JobType.REPEAT;
	}

	/**
	 * 根据任务名称和分组获取任务
	 *
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
	private ScheduleJob getScheduleJobByJobkey(String jobName, String jobGroup) {
		ScheduleJobExample example = new ScheduleJobExample();
		example.createCriteria().andDeleteFlagEqualTo(DelFlagEnum.UN_DELETED.getCode()).andJobNameEqualTo(jobName)
				.andJobGroupEqualTo(jobGroup);
		List<ScheduleJob> scheduleJobs = scheduleJobDao.selectByExample(example);
		if (scheduleJobs.size() > 0) {
			return scheduleJobs.get(0);
		}
		return null;
	}

}
