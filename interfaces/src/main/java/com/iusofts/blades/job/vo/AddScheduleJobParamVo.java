package com.iusofts.blades.job.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 添加定时任务模型Vo
 */
@ApiModel("定时任务添加参数")
public class AddScheduleJobParamVo {

	@ApiModelProperty(value = "系统代码", example = "product", required = true)
	@NotBlank(message = "系统代码不能为空")
	private String sysCode;

	@ApiModelProperty(value = "任务名称", example = "product_online_10101", required = true)
	@NotBlank(message = "任务名称不能为空")
	private String jobName;

	@ApiModelProperty(value = "任务别名", example = "产品(10101)定时上线")
	private String aliasName;

	@ApiModelProperty(value = "任务分组(可以用功能模块名称命名，确保jobName+jobGroup唯一性)", example = "product_online", required = true)
	@NotBlank(message = "任务分组不能为空")
	private String jobGroup;

	@ApiModelProperty(value = "是否异步(0否 1是)", required = true)
	@NotNull(message = "是否异步不能为空")
	@Range(min = 0, max = 1, message = "是否异步不合法")
	private Integer isSync;

	@ApiModelProperty(value = "任务执行url", required = true)
	@NotBlank(message = "任务执行url不能为空")
	private String url;

	@ApiModelProperty("url请求参数")
	private String requestParam;

	@ApiModelProperty(value = "请求方法（GET、POST）", example = "GET", required = true)
	@NotNull(message = "请求方法不能为空")
	@Pattern(regexp = "^GET|POST$", message = "请求方法不正确,仅支持GET和POST")
	private String requestMethod;

	@ApiModelProperty("最大努力重试次数（0代表不重试,最大值为10,重试间隔为1分钟、5分钟、10分钟、30分钟、1小时、2小时、5小时、10小时、15小时、24小时）")
	@Range(min = 0, max = 10, message = "最大努力重试次数不合法")
	private Integer maxRetryNum;

	@ApiModelProperty("任务描述")
	private String description;

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

	public Integer getMaxRetryNum() {
		return maxRetryNum;
	}

	public void setMaxRetryNum(Integer maxRetryNum) {
		this.maxRetryNum = maxRetryNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
