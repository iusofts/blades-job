package com.iusofts.blades.job.enums;

/**
 * 任务类型
 */
public enum JobType {

    ONCE(1,"一次性任务"),
    REPEAT(2,"重复任务");

    private int code;

    private String name;

    JobType(int code, String name) {
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
