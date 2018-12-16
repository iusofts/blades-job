package com.iusofts.blades.job.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.iusofts.blades.job.common.annotation.JsonDateDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 一次性定时任务模型Vo
 */
@ApiModel("定时任务添加参数")
public class AddOnceJobParamVo extends AddScheduleJobParamVo {

    @ApiModelProperty(value = "任务执行时间", example = "2017-11-06 20:40:00")
    @NotNull(message = "任务执行时间不能为空")
    @Future(message = "任务执行时间必须是一个将来的日期")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date executeTime;

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }
}
