package com.iusofts.blades.job.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("返回任务数")
public class CountScheduleJobResultVo implements Serializable {

    @ApiModelProperty("任务数量")
    private Integer count;

    public CountScheduleJobResultVo() {
    }

    public CountScheduleJobResultVo(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
