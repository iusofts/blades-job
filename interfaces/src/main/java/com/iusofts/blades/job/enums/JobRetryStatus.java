package com.iusofts.blades.job.enums;

/**
 * 任务重试状态
 */
public enum JobRetryStatus {

	NO_RETRY(0, "未重试"), RETRYING(1, "重试中"), RETRY_END(2, "重试结束");

	private int code;

	private String name;

	JobRetryStatus(int code, String name) {
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
