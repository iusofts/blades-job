package com.iusofts.blades.job.quartz;

import com.iusofts.blades.job.common.util.JsonUtils;
import com.iusofts.blades.job.constant.JobConstant;
import com.iusofts.blades.job.model.ScheduleJob;
import com.iusofts.blades.job.service.ScheduleJobService;
import com.iusofts.blades.job.util.BeanLocatorUtil;
import com.iusofts.blades.job.util.ScheduleJobExecuteUtil;
import com.iusofts.blades.job.enums.JobLevel;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 同步任务工厂
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SyncJobFactory extends QuartzJobBean {

	/* 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(SyncJobFactory.class);
	private static ScheduleJobService scheduleJobService = BeanLocatorUtil.getBean(ScheduleJobService.class);

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		LOG.info("Sync execute start");
		// 获取任务数据
		ScheduleJob scheduleJob = JsonUtils
				.json2obj((String) context.getMergedJobDataMap().get(JobConstant.JOB_PARAM_KEY), ScheduleJob.class);
		// 获取任务级别
		Integer jobLevel = (Integer) context.getMergedJobDataMap().get(JobConstant.JOB_LEVEL_KEY);
		// 任务数据有缓存 重新查询最新数据
		scheduleJob = scheduleJobService.get(scheduleJob.getId());
		// 执行任务
		ScheduleJobExecuteUtil.executeScheduleJob(scheduleJob, JobLevel.get(jobLevel));
		LOG.info("Sync execute  end, jobName:{} jobGroup:{}", scheduleJob.getJobName(), scheduleJob.getJobGroup());
	}
}
