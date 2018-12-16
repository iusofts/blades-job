package com.iusofts.blades.job.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 添加重复任务模型Vo
 */
@ApiModel("重复任务添加参数")
public class AddRepeatJobParamVo extends AddScheduleJobParamVo {

	@ApiModelProperty(value = "任务运行时间表达式:{秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}", example = "0 0/10 * * * ?", required = true)
	@NotBlank(message = "任务运行时间表达式不能为空")
	private String cronExpression;

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
}
