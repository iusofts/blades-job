package com.iusofts.blades.job.vo;

import com.iusofts.blades.job.common.page.Pagination;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("查询定时任务日志参数")
public class QueryScheduleJobLogParamVo implements Serializable {

    @ApiModelProperty("任务ID")
    private Long jobId;

    @ApiModelProperty("任务状态( 1 成功 2 失败 ）")
    private Integer status;

    @ApiModelProperty("分页参数")
    private Pagination pagination;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
