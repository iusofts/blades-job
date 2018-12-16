package com.iusofts.blades.job.enums;

/**
 * 任务异常
 */
public enum JobExceptionEnum {

    UNKNOWN(-1,"请求超时或服务不可用"),
    IERR(1,"任务系统内部错误"),
    EXPRESSION_ERROR(2,"表达式语法错误"),
    ALREADY_EXIST(3,"任务已存在"),
    NOT_FOUND(4,"任务未找到");

    private int code;

    private String name;

    JobExceptionEnum(int code, String name) {
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
