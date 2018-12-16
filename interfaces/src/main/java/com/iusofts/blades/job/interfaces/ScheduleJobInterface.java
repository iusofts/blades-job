package com.iusofts.blades.job.interfaces;


import com.iusofts.blades.job.vo.*;
import com.iusofts.blades.job.common.page.PagingResult;
import com.iusofts.blades.job.model.ScheduleJob;

/**
 * 定时任务服务
 */
public interface ScheduleJobInterface {

    /**
     * 新增重复任务
     *
     * @param paramVo
     * @return
     */
    Long addRepeatJob(AddRepeatJobParamVo paramVo);

    /**
     * 新增一次性任务
     *
     * @param paramVo
     * @return
     */
    Long addOnceJob(AddOnceJobParamVo paramVo);

    /**
     * 重建定时任务
     *
     * @param paramVo
     * @return
     */
    Long recreateRepeatJob(AddRepeatJobParamVo paramVo);

    /**
     * 重建一次性任务
     *
     * @param paramVo
     * @return
     */
    Long recreateOnceJob(AddOnceJobParamVo paramVo);

    /**
     * 删除
     *
     * @param scheduleJobId
     */
    void remove(Long scheduleJobId);

    /**
     * 运行一次任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    void runOnce(Long scheduleJobId);

    /**
     * 暂停任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    void pauseJob(Long scheduleJobId);

    /**
     * 恢复任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    void resumeJob(Long scheduleJobId);

    /**
     * 获取任务对象
     *
     * @param scheduleJobId
     * @return
     */
    ScheduleJob get(Long scheduleJobId);

    /**
     * 获取任务详细信息
     *
     * @param scheduleJobId
     * @return
     */
    ScheduleJobVo getDetail(Long scheduleJobId);

    /**
     * 根据jobkey获取任务对象
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    ScheduleJobVo getByKey(String jobName, String jobGroup);

    /**
     * 查询任务列表
     *
     * @param paramVo
     * @return
     */
    PagingResult<ScheduleJobVo> queryList(QueryScheduleJobParamVo paramVo);

    /**
     * 统计任务数量
     *
     * @param paramVo
     * @return
     */
    int count(CountScheduleJobParamVo paramVo);

    /**
     * 更新任务信息
     * （不重建任务，不影响在运行任务，影响任务需调用recreate接口）
     *
     * @param scheduleJob
     */
    void update(ScheduleJob scheduleJob);

    /**
     * 初始化定时任务
     */
    @Deprecated
    void initScheduleJob();

}
