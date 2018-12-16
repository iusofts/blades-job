package com.iusofts.blades.job.vo;

import com.iusofts.blades.job.common.page.Pagination;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("查询定时任务参数")
public class QueryScheduleJobParamVo implements Serializable {

    @ApiModelProperty("任务ID")
    private Long id;

    @ApiModelProperty("系统代码")
    private String sysCode;

    @ApiModelProperty("任务名称")
    private String jobName;

    @ApiModelProperty("任务别名")
    private String aliasName;

    @ApiModelProperty("任务分组")
    private String jobGroup;

    @ApiModelProperty("任务状态( 1 正常 2 暂停 3 完成 4 错误 5 阻塞 ）")
    private Integer status;

    @ApiModelProperty("分页参数")
    private Pagination pagination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
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
