package com.iusofts.blades.job.util;

import com.iusofts.blades.core.finder.ServiceCaller;
import com.iusofts.blades.job.common.util.JsonUtils;
import com.iusofts.blades.job.constant.JobConstant;
import com.iusofts.blades.job.enums.*;
import com.iusofts.blades.job.model.ScheduleJob;
import com.iusofts.blades.job.model.ScheduleJobLog;
import com.iusofts.blades.job.service.ScheduleJobLogService;
import com.iusofts.blades.job.service.ScheduleJobService;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 定时任务执行工具类
 */
public class ScheduleJobExecuteUtil {

    /* 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleJobExecuteUtil.class);

    private static Scheduler scheduler = BeanLocatorUtil.getBean(Scheduler.class);
    private static ScheduleJobLogService jobLogService = BeanLocatorUtil.getBean(ScheduleJobLogService.class);
    private static ScheduleJobService scheduleJobService = BeanLocatorUtil.getBean(ScheduleJobService.class);
    private static ServiceCaller serviceCaller = BeanLocatorUtil.getBean(ServiceCaller.class);


    /**
     * 执行定时任务
     *
     * @param scheduleJob
     * @return
     */
    public static void executeScheduleJob(ScheduleJob scheduleJob, JobLevel jobLevel) {

        // 设置任务开始时间
        scheduleJob.setLastStartTime(new Date());

        // 请求接口
        Object response = null;
        Object requestParam = StringUtils.isNotBlank(scheduleJob.getRequestParam())
                ? JsonUtils.json2map(scheduleJob.getRequestParam()) : null;
        String msg;
        boolean isSuccess = false;
        try {
            switch (scheduleJob.getRequestMethod()) {
                case "GET":
                    response = serviceCaller.get(scheduleJob.getUrl(), requestParam, Object.class);
                    break;
                case "POST":
                    response = serviceCaller.post(scheduleJob.getUrl(), requestParam, Object.class);
                    break;
            }
            isSuccess = true;
            msg = "success";
        } catch (Exception e) {
            msg = ExceptionUtils.getFullStackTrace(e);
            LOG.error("executeScheduleJob Failed", e);
        }


        // 处理结果
        if (jobLevel == JobLevel.MASTER) {
            scheduleJob.setRetriedNum(0);// 主任务执行错误重试数归零
        } else {
            int retriedNum = scheduleJob.getRetriedNum() == null ? 1 : scheduleJob.getRetriedNum() + 1;// 子任务累计重试数
            scheduleJob.setRetriedNum(retriedNum);// 累计失败重试次数
        }

        if (isSuccess) {
            scheduleJob.setRetriedNum(0);// 成功后错误重试数归零
        } else {
            retry(scheduleJob);// 失败重试
        }

        // 设置任务结束时间
        scheduleJob.setLastEndTime(new Date());

        // 更新任务状态
        updateJobStatus(scheduleJob, isSuccess);

        // 保存日志
        saveResponseLog(scheduleJob, isSuccess, response, msg);
    }

    /**
     * 更新任务状态
     */
    public static void updateJobStatus(ScheduleJob scheduleJob, boolean success) {
        if (success) {
            scheduleJob.setNextFireTime(-1L);// 默认认为无下次时间
            // 一次性任务算作完成
            if (scheduleJob.getJobType() == JobType.ONCE.getCode()) {
                scheduleJob.setStatus(JobStatus.COMPLETE.getCode());
            } else {
                // 重复任务需要判断是否还有下一次
                JobStatus jobStatus = JobStatus.COMPLETE;
                Long nextFireTime = getNextFireTime(scheduleJob.getJobName(), scheduleJob.getJobGroup());
                if (nextFireTime != null) {
                    jobStatus = JobStatus.NORMAL;
                    scheduleJob.setNextFireTime(nextFireTime);
                }
                scheduleJob.setStatus(jobStatus.getCode());
            }
        } else {
            scheduleJob.setStatus(JobStatus.ERROR.getCode());
            int totalFailedNum = scheduleJob.getTotalFailedNum() == null ? 0 : scheduleJob.getTotalFailedNum() + 1;// 失败总数(用于统计)
            scheduleJob.setTotalFailedNum(totalFailedNum);
        }
        // FIXME 解决并发累加问题（编写sql）
        int totalRunNum = scheduleJob.getTotalRunNum() == null ? 0 : scheduleJob.getTotalRunNum() + 1;// 执行总数(用于统计)
        scheduleJob.setTotalRunNum(totalRunNum);
        scheduleJobService.update(scheduleJob);
    }

    /**
     * 保存响应任务日志
     */
    public static void saveResponseLog(ScheduleJob scheduleJob, boolean isSuccess, Object response, String msg) {

        // 创建日志对象
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
        scheduleJobLog.setJobId(scheduleJob.getId());
        scheduleJobLog.setUrl(scheduleJob.getUrl());
        scheduleJobLog.setRequestMethod(scheduleJob.getRequestMethod());
        scheduleJobLog.setRequestParam(scheduleJob.getRequestParam());
        scheduleJobLog.setStartTime(scheduleJob.getLastStartTime());
        scheduleJobLog.setEndTime(scheduleJob.getLastEndTime());

        if (isSuccess) {
            scheduleJobLog.setStatus(JobLogStatus.SUCCESS.getCode());
            LOG.info("execute success:{}", scheduleJob.getId());
        } else {
            scheduleJobLog.setErrorType(JobErrorType.EXT_ERROR.getCode());
            scheduleJobLog.setStatus(JobLogStatus.FAILD.getCode());
            LOG.error("execute failed:{}", scheduleJob.getId());
        }
        if (response != null) {
            scheduleJobLog.setResponse(JsonUtils.obj2json(response));
        }
        scheduleJobLog.setErrorMsg(msg);

        jobLogService.add(scheduleJobLog);
    }

    /**
     * 保存内部错误任务日志
     *
     * @param scheduleJob
     * @param errorMsg
     */
    public static void saveIerrLog(ScheduleJob scheduleJob, String errorMsg) {

        // 创建日志对象
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
        scheduleJobLog.setJobId(scheduleJob.getId());
        scheduleJobLog.setUrl(scheduleJob.getUrl());
        scheduleJobLog.setRequestMethod(scheduleJob.getRequestMethod());
        scheduleJobLog.setRequestParam(scheduleJob.getRequestParam());
        scheduleJobLog.setStartTime(scheduleJob.getLastStartTime());
        scheduleJobLog.setEndTime(scheduleJob.getLastEndTime());

        scheduleJobLog.setStatus(JobLogStatus.FAILD.getCode());
        scheduleJobLog.setErrorType(JobErrorType.IERR.getCode());
        scheduleJobLog.setErrorMsg(errorMsg);

        jobLogService.add(scheduleJobLog);
    }

    /**
     * 任务错误重试
     *
     * @param scheduleJob
     */
    public static void retry(ScheduleJob scheduleJob) {
        // 判断是否需要重试(重试次数不超过最大重试次数)
        if (scheduleJob.getMaxRetryNum() > 0 && scheduleJob.getRetriedNum() < scheduleJob.getMaxRetryNum()) {
            // 计算下次重试时间
            Long nextRetryTime;// 下次重试时间
            if (scheduleJob.getRetriedNum() == 0) {
                nextRetryTime = JobConstant.RETRY_INTERVALS[0] * 1000L + new Date().getTime();
            } else {
                nextRetryTime = (JobConstant.RETRY_INTERVALS[scheduleJob.getRetriedNum()]
                        - JobConstant.RETRY_INTERVALS[scheduleJob.getRetriedNum() - 1]) * 1000L + new Date().getTime();
            }

            // 下次重试时间表达式
            String nextRetryCronExperssion = executeTimeToCronExperssion(new Date(nextRetryTime));

            // 获取任务下次执行时间
            Long nextFireTime = getNextFireTime(scheduleJob.getJobName(), scheduleJob.getJobGroup());
            // 如果任务的下一次周期小于下次重试时间,则不参与重试
            if (nextFireTime == null || nextFireTime > nextRetryTime) {
                // 先删除
                ScheduleUtil.deleteChildJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
                // 再创建
                ScheduleUtil.createScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(),
                        JobLevel.CHILD, nextRetryCronExperssion, scheduleJob.getIsSync() == 1, scheduleJob);
            } else {
                scheduleJob.setNextFireTime(nextFireTime);
            }

            scheduleJob.setRetryStatus(JobRetryStatus.RETRYING.getCode());
        } else {
            scheduleJob.setRetryStatus(JobRetryStatus.RETRY_END.getCode());
        }

    }

    /**
     * 获取任务下次执行时间
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    public static Long getNextFireTime(String jobName, String jobGroup) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            Trigger trigger = scheduler.getTrigger(triggerKey);
            if (trigger != null && trigger.getNextFireTime() != null) {
                return trigger.getNextFireTime().getTime();
            }
        } catch (SchedulerException e) {
            LOG.error("getNextFireTime error", e);
        }
        return null;
    }

    /**
     * 执行时间转表达式
     *
     * @param executeTime
     * @return
     */
    public static String executeTimeToCronExperssion(Date executeTime) {
        // {second} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
        Calendar cal = Calendar.getInstance();
        cal.setTime(executeTime);
        return MessageFormat.format("{0} {1} {2} {3} {4} ? {5}", cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.DATE), cal.get(Calendar.MONTH) + 1,
                String.valueOf(cal.get(Calendar.YEAR)));
    }

}
