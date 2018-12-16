package com.iusofts.blades.job.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("任务key")
public class ScheduleJobKeyVo {

    @ApiModelProperty("任务名称")
    @NotBlank(message = "任务名称不能为空")
    private String jobName;

    @ApiModelProperty("任务分组")
    @NotBlank(message = "任务分组不能为空")
    private String jobGroup;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }
}
