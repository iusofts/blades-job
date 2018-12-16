package com.iusofts.blades.job.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iusofts.blades.job.common.annotation.JsonDateSerializer;
import com.iusofts.blades.job.common.annotation.JsonMSDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务模型Vo
 */
@ApiModel("任务信息")
public class ScheduleJobVo implements Serializable {

    @ApiModelProperty("任务ID")
    private Long id;

    @ApiModelProperty("系统代码")
    private String sysCode;

    @ApiModelProperty("任务类型（1.一次性任务 2.重复任务）")
    private Integer jobType;

    @ApiModelProperty("任务名称")
    private String jobName;

    @ApiModelProperty("任务别名")
    private String aliasName;

    @ApiModelProperty("任务分组")
    private String jobGroup;

    @ApiModelProperty("触发器")
    private String jobTrigger;

    @ApiModelProperty("任务状态( 1 正常 2 暂停 3 完成 4 错误 5 阻塞 ）")
    private Integer status;

    @ApiModelProperty("触发器状态( 1 正常 2 暂停 3 完成 4 错误 5 阻塞 ）")
    private Integer triggerStatus;

    @ApiModelProperty("任务运行时间表达式")
    private String cronExpression;

    @ApiModelProperty("单次任务执行时间（和表达式对应）")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date executeTime;

    @ApiModelProperty("是否异步")
    private Integer isSync;

    @ApiModelProperty("任务执行url")
    private String url;

    @ApiModelProperty("url请求参数")
    private String requestParam;

    @ApiModelProperty("请求方法（get、post等）")
    private String requestMethod;

    @ApiModelProperty("任务描述")
    private String description;

    @ApiModelProperty("最大重试次数（0代表不重试）")
    private Integer maxRetryNum;

    @ApiModelProperty("失败重试次数")
    private Integer retriedNum;

    @ApiModelProperty("重试状态（0未重试 1重试中 2重试结束）")
    private Integer retryStatus;

    @ApiModelProperty("运行总次数")
    private Integer totalRunNum;

    @ApiModelProperty("运行错误总数")
    private Integer totalFailedNum;

    @ApiModelProperty("最后一次开始时间")
    @JsonSerialize(using = JsonMSDateSerializer.class)
    private Date lastStartTime;

    @ApiModelProperty("最后一次结束时间")
    @JsonSerialize(using = JsonMSDateSerializer.class)
    private Date lastEndTime;

    @ApiModelProperty("下次执行时间(毫秒数，-1表示无下次)")
    private Long nextFireTime;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date updateTime;

    @ApiModelProperty("删除标识(0未删除 1已删除)")
    private Integer deleteFlag;

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

    public String getJobTrigger() {
        return jobTrigger;
    }

    public void setJobTrigger(String jobTrigger) {
        this.jobTrigger = jobTrigger;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Integer getIsSync() {
        return isSync;
    }

    public void setIsSync(Integer isSync) {
        this.isSync = isSync;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxRetryNum() {
        return maxRetryNum;
    }

    public void setMaxRetryNum(Integer maxRetryNum) {
        this.maxRetryNum = maxRetryNum;
    }

    public Integer getRetriedNum() {
        return retriedNum;
    }

    public void setRetriedNum(Integer retriedNum) {
        this.retriedNum = retriedNum;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getTotalRunNum() {
        return totalRunNum;
    }

    public void setTotalRunNum(Integer totalRunNum) {
        this.totalRunNum = totalRunNum;
    }

    public Integer getTotalFailedNum() {
        return totalFailedNum;
    }

    public void setTotalFailedNum(Integer totalFailedNum) {
        this.totalFailedNum = totalFailedNum;
    }

    public Date getLastStartTime() {
        return lastStartTime;
    }

    public void setLastStartTime(Date lastStartTime) {
        this.lastStartTime = lastStartTime;
    }

    public Date getLastEndTime() {
        return lastEndTime;
    }

    public void setLastEndTime(Date lastEndTime) {
        this.lastEndTime = lastEndTime;
    }

    public Integer getTriggerStatus() {
        return triggerStatus;
    }

    public void setTriggerStatus(Integer triggerStatus) {
        this.triggerStatus = triggerStatus;
    }

    public Long getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Long nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public Integer getRetryStatus() {
        return retryStatus;
    }

    public void setRetryStatus(Integer retryStatus) {
        this.retryStatus = retryStatus;
    }
}
