package com.iusofts.blades.job.model;

import java.io.Serializable;
import java.util.Date;

public class ScheduleJob implements Serializable {
    /**
     *任务ID
     */
    private Long id;

    /**
     *系统代码(product、poi等)
     */
    private String sysCode;

    /**
     *任务类型（1.一次性任务 2.重复任务）
     */
    private Integer jobType;

    /**
     *任务名称
     */
    private String jobName;

    /**
     *任务别名
     */
    private String aliasName;

    /**
     *任务分组
     */
    private String jobGroup;

    /**
     *触发器
     */
    private String jobTrigger;

    /**
     *任务状态( 1 正常 2 暂停 3 完成 4 错误 5 阻塞 ）
     */
    private Integer status;

    /**
     *任务运行时间表达式
     */
    private String cronExpression;

    /**
     *单次任务执行时间（和表达式对应）
     */
    private Date executeTime;

    /**
     *是否异步(1是 0否)
     */
    private Integer isSync;

    /**
     *任务执行url
     */
    private String url;

    /**
     *url请求参数
     */
    private String requestParam;

    /**
     *请求方法（get、post等）
     */
    private String requestMethod;

    /**
     *任务描述
     */
    private String description;

    /**
     *最大重试次数（0代表不重试）
     */
    private Integer maxRetryNum;

    /**
     *已重试次数
     */
    private Integer retriedNum;

    /**
     *重试状态（0未重试 1重试中 2重试结束）
     */
    private Integer retryStatus;

    /**
     *运行总次数
     */
    private Integer totalRunNum;

    /**
     *运行错误总数
     */
    private Integer totalFailedNum;

    /**
     *最后一次开始时间
     */
    private Date lastStartTime;

    /**
     *最后一次结束时间
     */
    private Date lastEndTime;

    /**
     *下次执行时间(毫秒数，-1表示无下次)
     */
    private Long nextFireTime;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;

    /**
     *删除标识(0未删除 1已删除)
     */
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

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
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

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
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

    public Integer getRetryStatus() {
        return retryStatus;
    }

    public void setRetryStatus(Integer retryStatus) {
        this.retryStatus = retryStatus;
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

    public Long getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Long nextFireTime) {
        this.nextFireTime = nextFireTime;
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
}