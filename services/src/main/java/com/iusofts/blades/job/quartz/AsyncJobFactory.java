package com.iusofts.blades.job.quartz;

import com.iusofts.blades.job.common.util.JsonUtils;
import com.iusofts.blades.job.constant.JobConstant;
import com.iusofts.blades.job.enums.JobLevel;
import com.iusofts.blades.job.model.ScheduleJob;
import com.iusofts.blades.job.service.ScheduleJobService;
import com.iusofts.blades.job.util.BeanLocatorUtil;
import com.iusofts.blades.job.util.ScheduleJobExecuteUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 异步任务工厂
 */
public class AsyncJobFactory extends QuartzJobBean {

	/* 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(AsyncJobFactory.class);
	private static ScheduleJobService scheduleJobService = BeanLocatorUtil.getBean(ScheduleJobService.class);

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		LOG.info("Async execute start");
		// 获取任务数据
		ScheduleJob scheduleJob = JsonUtils
				.json2obj((String) context.getMergedJobDataMap().get(JobConstant.JOB_PARAM_KEY), ScheduleJob.class);
		// 获取任务级别
		Integer jobLevel = (Integer) context.getMergedJobDataMap().get(JobConstant.JOB_LEVEL_KEY);
		// 任务数据有缓存 重新查询最新数据
		scheduleJob = scheduleJobService.get(scheduleJob.getId());
		// 执行任务
		ScheduleJobExecuteUtil.executeScheduleJob(scheduleJob, JobLevel.get(jobLevel));
		LOG.info("Async execute  end, jobName:{} jobGroup:{}", scheduleJob.getJobName(), scheduleJob.getJobGroup());
	}

}
