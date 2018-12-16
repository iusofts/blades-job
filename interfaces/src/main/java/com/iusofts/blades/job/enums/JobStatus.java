package com.iusofts.blades.job.enums;

/**
 * 任务状态
 */
public enum JobStatus {

	NORMAL(1, "正常"), PAUSED(2, "暂停"), COMPLETE(3, "完成"), ERROR(4, "错误"), BLOCKED(5, "阻塞"), RETRY(6, "重试");// 重试为虚拟状态

	private int code;

	private String name;

	JobStatus(int code, String name) {
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
