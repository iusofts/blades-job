package com.iusofts.blades.job.exceptions;

/**
 * 业务的接口异常，基于ErrorCode的业务类异常的基类
 */
public abstract class AbstractBusinessException extends RuntimeException {

    private final Object data;

    private final int code;

    public AbstractBusinessException(String message, int code) {
        super(message);
        this.data = null;
        this.code = code;
    }

    public AbstractBusinessException(String message, int code, Throwable throwable) {
        super(message, throwable);
        this.data = null;
        this.code = code;
    }

    public AbstractBusinessException(Object data, String message, int code) {
        super(message);
        this.data = data;
        this.code = code;
    }

    public AbstractBusinessException(Object data, String message, int code, Throwable throwable) {
        super(message, throwable);
        this.data = data;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

}
