package com.iusofts.blades.job.enums;

/**
 * 任务日志状态
 */
public enum JobLogStatus {

    SUCCESS(1,"成功"),
    FAILD(2,"失败");

    private int code;

    private String name;

    JobLogStatus(int code, String name) {
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
