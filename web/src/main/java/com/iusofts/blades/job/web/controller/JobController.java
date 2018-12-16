package com.iusofts.blades.job.web.controller;

import com.iusofts.blades.job.common.page.PagingResult;
import com.iusofts.blades.job.common.validation.ValidationUtils;
import com.iusofts.blades.job.enums.JobExceptionEnum;
import com.iusofts.blades.job.exceptions.ScheduleException;
import com.iusofts.blades.job.vo.*;
import com.iusofts.blades.job.service.ScheduleJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "定时任务")
@RestController
@RequestMapping(value = "/scheduleJob")
public class JobController {

	@Autowired
	private ScheduleJobService scheduleJobService;

	@ApiOperation(value = "查询任务列表")
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public PagingResult<ScheduleJobVo> queryList(@RequestBody QueryScheduleJobParamVo paramVo) {
		return this.scheduleJobService.queryList(paramVo);
	}

	@ApiOperation(value = "获取任务详情")
	@RequestMapping(value = "/getDetail", method = RequestMethod.POST)
	public ScheduleJobVo getDetail(@RequestBody ScheduleJobIdVo paramVo) {
		return this.scheduleJobService.getDetail(paramVo.getId());
	}

	@ApiOperation(value = "根据key获取任务信息")
	@RequestMapping(value = "/getByKey", method = RequestMethod.POST)
	public ScheduleJobVo getByKey(@RequestBody ScheduleJobKeyVo paramVo) {
		return this.scheduleJobService.getByKey(paramVo.getJobName(), paramVo.getJobGroup());
	}

	@ApiOperation(value = "添加一次性任务", notes = "需要确保jobName+jobGroup唯一性")
	@RequestMapping(value = "/addOnceJob", method = RequestMethod.POST)
	public ScheduleJobIdVo addOnceJob(@RequestBody AddOnceJobParamVo paramVo) {
		ValidationUtils.validate(paramVo);//FIXME 框架校验日期未拦截
		return new ScheduleJobIdVo(this.scheduleJobService.addOnceJob(paramVo));
	}

	@ApiOperation(value = "添加重复任务", notes = "需要确保jobName+jobGroup唯一性")
	@RequestMapping(value = "/addRepeatJob", method = RequestMethod.POST)
	public ScheduleJobIdVo addRepeatJob(@RequestBody AddRepeatJobParamVo paramVo) {
		return new ScheduleJobIdVo(this.scheduleJobService.addRepeatJob(paramVo));
	}

	@ApiOperation(value = "重建一次性任务", notes = "先删除旧任务后创建新任务")
	@RequestMapping(value = "/recreateOnceJob", method = RequestMethod.POST)
	public ScheduleJobIdVo recreateOnceJob(@RequestBody AddOnceJobParamVo paramVo) {
		ValidationUtils.validate(paramVo);
		return new ScheduleJobIdVo(this.scheduleJobService.recreateOnceJob(paramVo));
	}

	@ApiOperation(value = "重建重复任务", notes = "先删除旧任务后创建新任务")
	@RequestMapping(value = "/recreateRepeatJob", method = RequestMethod.POST)
	public ScheduleJobIdVo recreateRepeatJob(@RequestBody AddRepeatJobParamVo paramVo) {
		return new ScheduleJobIdVo(this.scheduleJobService.recreateRepeatJob(paramVo));
	}

	@ApiOperation(value = "删除任务")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public void remove(@RequestBody ScheduleJobIdVo paramVo) {
		this.scheduleJobService.remove(paramVo.getId());
	}

	@ApiOperation(value = "根据key删除任务")
	@RequestMapping(value = "/removeByKey", method = RequestMethod.POST)
	public void removeByKey(@RequestBody ScheduleJobKeyVo paramVo) {
		ScheduleJobVo scheduleJobVo = this.scheduleJobService.getByKey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJobVo != null) {
			this.scheduleJobService.remove(scheduleJobVo.getId());
		} else {
			throw new ScheduleException(JobExceptionEnum.NOT_FOUND.getCode(), "job not found");
		}
	}

	@ApiOperation(value = "暂停任务")
	@RequestMapping(value = "/pauseJob", method = RequestMethod.POST)
	public void pauseJob(@RequestBody ScheduleJobIdVo paramVo) {
		this.scheduleJobService.pauseJob(paramVo.getId());
	}

	@ApiOperation(value = "根据key暂停任务")
	@RequestMapping(value = "/pauseJobByKey", method = RequestMethod.POST)
	public void pauseJobByKey(@RequestBody ScheduleJobKeyVo paramVo) {
		ScheduleJobVo scheduleJobVo = this.scheduleJobService.getByKey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJobVo != null) {
			this.scheduleJobService.pauseJob(scheduleJobVo.getId());
		} else {
			throw new ScheduleException(JobExceptionEnum.NOT_FOUND.getCode(), "job not found");
		}
	}

	@ApiOperation(value = "恢复任务")
	@RequestMapping(value = "/resumeJob", method = RequestMethod.POST)
	public void resumeJob(@RequestBody ScheduleJobIdVo paramVo) {
		this.scheduleJobService.resumeJob(paramVo.getId());
	}

	@ApiOperation(value = "根据key恢复任务")
	@RequestMapping(value = "/resumeJobByKey", method = RequestMethod.POST)
	public void resumeJobByKey(@RequestBody ScheduleJobKeyVo paramVo) {
		ScheduleJobVo scheduleJobVo = this.scheduleJobService.getByKey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJobVo != null) {
			this.scheduleJobService.resumeJob(scheduleJobVo.getId());
		} else {
			throw new ScheduleException(JobExceptionEnum.NOT_FOUND.getCode(), "job not found");
		}
	}

	@ApiOperation(value = "运行一次", notes = "可用于测试使用")
	@RequestMapping(value = "/runOnce", method = RequestMethod.POST)
	public void runOnce(@RequestBody ScheduleJobIdVo paramVo) {
		this.scheduleJobService.runOnce(paramVo.getId());
	}

	@ApiOperation(value = "根据key运行一次")
	@RequestMapping(value = "/runOnceByKey", method = RequestMethod.POST)
	public void runOnceByKey(@RequestBody ScheduleJobKeyVo paramVo) {
		ScheduleJobVo scheduleJobVo = this.scheduleJobService.getByKey(paramVo.getJobName(), paramVo.getJobGroup());
		if (scheduleJobVo != null) {
			this.scheduleJobService.runOnce(scheduleJobVo.getId());
		} else {
			throw new ScheduleException(JobExceptionEnum.NOT_FOUND.getCode(), "job not found");
		}
	}

	@ApiOperation(value = "统计任务数", notes = "运维接口")
	@RequestMapping(value = "/count", method = RequestMethod.POST)
	public CountScheduleJobResultVo count(@RequestBody CountScheduleJobParamVo paramVo) {
		return new CountScheduleJobResultVo(this.scheduleJobService.count(paramVo));
	}

}
