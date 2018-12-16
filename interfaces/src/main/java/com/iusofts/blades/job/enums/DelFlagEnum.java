package com.iusofts.blades.job.enums;

/**
 * 删除标志枚举
 */
public enum DelFlagEnum {

    UN_DELETED(0,"未删除"),
    DELETED(1,"已删除");

    private int code;

    private String name;

    DelFlagEnum(int code, String name) {
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
