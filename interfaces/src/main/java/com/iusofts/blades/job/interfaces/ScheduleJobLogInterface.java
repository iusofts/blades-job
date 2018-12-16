package com.iusofts.blades.job.interfaces;


import com.iusofts.blades.job.common.page.PagingResult;
import com.iusofts.blades.job.model.ScheduleJobLog;
import com.iusofts.blades.job.vo.QueryScheduleJobLogParamVo;
import com.iusofts.blades.job.vo.ScheduleJobLogVo;

/**
 * 定时任务日志服务
 */
public interface ScheduleJobLogInterface {

    /**
     * 添加
     *
     * @param scheduleJobLog
     * @return
     */
    Long add(ScheduleJobLog scheduleJobLog);

    /**
     * 删除
     *
     * @param logId
     */
    void remove(Long logId);

    /**
     * 根据日志ID获取日志信息
     *
     * @param logId
     * @return
     */
    ScheduleJobLogVo getById(Long logId);

    /**
     * 根据任务ID获取日志信息（最新一条）
     *
     * @param scheduleJobId
     * @return
     */
    ScheduleJobLogVo getByJobId(Long scheduleJobId);

    /**
     * 查询任务日志列表
     *
     * @param paramVo
     * @return
     */
    PagingResult<ScheduleJobLogVo> queryList(QueryScheduleJobLogParamVo paramVo);

}
