package com.iusofts.blades.job.enums;

/**
 * 任务错误类型
 */
public enum JobErrorType {

	NORMAL(0, "正常"), IERR(1, "内部错误"), EXT_ERROR(2, "外部错误");

	private int code;

	private String name;

	JobErrorType(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
