package com.iusofts.blades.job.enums;

/**
 * 任务级别
 */
public enum JobLevel {

    MASTER(1,"主任务"),
    CHILD(2,"子任务");

    private int code;

    private String name;

    JobLevel(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static JobLevel get(int code) {
        for (JobLevel c : JobLevel.values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        return null;
    }

    public static String getName(int code) {
        for (JobLevel c : JobLevel.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
