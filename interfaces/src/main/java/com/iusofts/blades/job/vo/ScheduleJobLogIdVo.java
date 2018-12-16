package com.iusofts.blades.job.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 定时任务日志ID
 */
public class ScheduleJobLogIdVo {

    @ApiModelProperty("任务日志ID")
    @NotNull(message = "任务日志ID不能为空")
    private Long id;

    public ScheduleJobLogIdVo() {
    }

    public ScheduleJobLogIdVo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
