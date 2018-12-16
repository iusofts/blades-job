package com.iusofts.blades.job.listener;

import com.iusofts.blades.job.common.util.JsonUtils;
import com.iusofts.blades.job.constant.JobConstant;
import com.iusofts.blades.job.enums.JobLevel;
import com.iusofts.blades.job.model.ScheduleJob;
import com.iusofts.blades.job.quartz.SyncJobFactory;
import com.iusofts.blades.job.service.ScheduleJobService;
import com.iusofts.blades.job.util.BeanLocatorUtil;
import com.iusofts.blades.job.util.ScheduleJobExecuteUtil;
import com.iusofts.blades.job.util.ScheduleUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ScheduleJobListener implements JobListener {

    /* 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(SyncJobFactory.class);
    /** 调度工厂Bean */
    private Scheduler scheduler = BeanLocatorUtil.getBean(Scheduler.class);
    private ScheduleJobService scheduleJobService = BeanLocatorUtil.getBean(ScheduleJobService.class);

    @Override
    public String getName() {
        return "ScheduleJobListener"; // 一定要设置名称
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        ScheduleJob scheduleJob = JsonUtils.json2obj((String)mergedJobDataMap.get(JobConstant.JOB_PARAM_KEY), ScheduleJob.class);
        System.out.println("jobToBeExecuted jobName:" + scheduleJob.getJobName());

        // 主任务进入下一次周期 清除正在重试的子任务
        if (scheduler == null){
            scheduler = BeanLocatorUtil.getBean(Scheduler.class);
        }
        ScheduleUtil.deleteChildJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        /*JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        ScheduleJob scheduleJob = (ScheduleJob) mergedJobDataMap.get(ScheduleJobConstant.JOB_PARAM_KEY);
        System.out.println("jobExecutionVetoed jobName:" + scheduleJob.getJobName());*/
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		if (scheduleJobService == null){
            scheduleJobService = BeanLocatorUtil.getBean(ScheduleJobService.class);
        }
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        ScheduleJob scheduleJob = JsonUtils.json2obj((String)mergedJobDataMap.get(JobConstant.JOB_PARAM_KEY), ScheduleJob.class);
        if (jobException != null) {// 异常处理
            LOG.error("jobExecutionException jobName :" + scheduleJob.getJobName(), jobException);
            System.err.println(jobException.getMessage());
            // 任务数据有缓存 重新查询最新数据
            scheduleJob = scheduleJobService.get(scheduleJob.getId());
            // 错误重试
            // 获取任务级别
            Integer jobLevel = (Integer) context.getMergedJobDataMap().get(JobConstant.JOB_LEVEL_KEY);
            if(JobLevel.MASTER.getCode() == jobLevel){
                scheduleJob.setRetriedNum(0);// 主任务执行错误重试数归零
            }else {
                int retriedNum = scheduleJob.getRetriedNum() == null ? 1 : scheduleJob.getRetriedNum()+1;// 子任务累计重试数
                scheduleJob.setRetriedNum(retriedNum);// 累计失败重试次数
            }
            ScheduleJobExecuteUtil.retry(scheduleJob);
            // 更新任务状态
            scheduleJob.setLastStartTime(context.getTrigger().getStartTime());
            scheduleJob.setLastEndTime(new Date());
            ScheduleJobExecuteUtil.updateJobStatus(scheduleJob, false);

            // 记录日志
            ScheduleJobExecuteUtil.saveIerrLog(scheduleJob, jobException.getMessage());
        }
        System.out.println("jobWasExecuted jobName:" + scheduleJob.getJobName());
    }
}