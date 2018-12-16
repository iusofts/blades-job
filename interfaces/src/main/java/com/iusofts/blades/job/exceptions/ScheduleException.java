package com.iusofts.blades.job.exceptions;


/**
 * 定时任务自定义异常
 */
public class ScheduleException extends AbstractBusinessException {

	public ScheduleException(Throwable e) {
		super("ScheduleException", 500, e);
	}

	public ScheduleException(String message) {
		super(message, 500);
	}

	public ScheduleException(int code, String message) {
		super(message, code);
	}
}
