package com.iusofts.blades.job.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务ID
 */
public class ScheduleJobIdVo {

    @ApiModelProperty("任务ID")
    @NotNull(message = "任务ID不能为空")
    private Long id;

    public ScheduleJobIdVo() {
    }

    public ScheduleJobIdVo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
