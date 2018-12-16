package com.iusofts.blades.job.web.controller;

import com.iusofts.blades.job.common.page.PagingResult;
import com.iusofts.blades.job.enums.JobExceptionEnum;
import com.iusofts.blades.job.exceptions.ScheduleException;
import com.iusofts.blades.job.service.ScheduleJobLogService;
import com.iusofts.blades.job.service.ScheduleJobService;
import com.iusofts.blades.job.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "定时任务日志")
@RestController
@RequestMapping(value = "/scheduleJobLog")
public class JobLogController {

	@Autowired
	private ScheduleJobLogService scheduleJobLogService;

	@Autowired
	private ScheduleJobService scheduleJobService;

	@ApiOperation(value = "查询任务列表")
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public PagingResult<ScheduleJobLogVo> queryList(@RequestBody QueryScheduleJobLogParamVo paramVo) {
		return this.scheduleJobLogService.queryList(paramVo);
	}

	@ApiOperation(value = "根据日志ID获取任务最新日志信息")
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ScheduleJobLogVo getById(@RequestBody ScheduleJobLogIdVo paramVo) {
		return this.scheduleJobLogService.getById(paramVo.getId());
	}

	@ApiOperation(value = "根据任务ID获取任务最新日志信息")
	@RequestMapping(value = "/getByJobId", method = RequestMethod.POST)
	public ScheduleJobLogVo getByJobId(@RequestBody ScheduleJobIdVo paramVo) {
		return this.scheduleJobLogService.getByJobId(paramVo.getId());
	}

	@ApiOperation(value = "根据key获取最新日志信息")
	@RequestMapping(value = "/getByKey", method = RequestMethod.POST)
	public ScheduleJobLogVo getByKey(@RequestBody ScheduleJobKeyVo paramVo) {
		ScheduleJobVo scheduleJobVo = this.scheduleJobService.getByKey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJobVo != null) {
			return this.scheduleJobLogService.getByJobId(scheduleJobVo.getId());
		} else {
			throw new ScheduleException(JobExceptionEnum.NOT_FOUND.getCode(), "job not found");
		}
	}

	@ApiOperation(value = "删除日志")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public void remove(@RequestBody ScheduleJobLogIdVo paramVo) {
		this.scheduleJobLogService.remove(paramVo.getId());
	}

}
