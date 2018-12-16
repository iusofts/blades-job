package com.iusofts.blades.job.constant;

/**
 * 定时任务常量
 */
public interface JobConstant {

    /** 任务调度的参数key */
    String JOB_PARAM_KEY    = "jobParam";//任务参数
    String JOB_LEVEL_KEY    = "jobLevel";//任务等级

    String CHILD_JOB_PREFIX = "childJob_";//子任务名称前缀

    /**
     * 任务失败重试间隔(单位s)
     */
    int[] RETRY_INTERVALS = new int[]{1*60, 5*60, 10*60, 30*60, 60*60, 2*3600, 5*3600, 10*600, 15*3600, 24*3600};

}
