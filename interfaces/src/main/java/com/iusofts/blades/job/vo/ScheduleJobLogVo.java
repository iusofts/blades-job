package com.iusofts.blades.job.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iusofts.blades.job.common.annotation.JsonDateSerializer;
import com.iusofts.blades.job.common.annotation.JsonMSDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("定时任务日志信息")
public class ScheduleJobLogVo {

    @ApiModelProperty("日志ID")
    private Long id;

    @ApiModelProperty("任务ID")
    private Long jobId;

    @ApiModelProperty("任务执行url")
    private String url;

    @ApiModelProperty("url请求参数")
    private String requestParam;

    @ApiModelProperty("请求方法（get、post等）")
    private String requestMethod;

    @ApiModelProperty("响应")
    private String response;

    @ApiModelProperty("任务状态( 1 成功 2 失败 ）")
    private Integer status;

    @ApiModelProperty("错误类型（1内部错误 2外部错误）")
    private Integer errorType;

    @ApiModelProperty("错误消息")
    private String errorMsg;

    @ApiModelProperty("任务开始时间")
    @JsonSerialize(using = JsonMSDateSerializer.class)
    private Date startTime;

    @ApiModelProperty("任务结束时间")
    @JsonSerialize(using = JsonMSDateSerializer.class)
    private Date endTime;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getErrorType() {
        return errorType;
    }

    public void setErrorType(Integer errorType) {
        this.errorType = errorType;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}