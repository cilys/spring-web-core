package com.cilys.web.core.exception;

/**
 * Created by Administrator on 2024/11/21.
 */
public class RunException extends RuntimeException {
    public RunException() {
        super();
    }

    public RunException(String message) {
        super(message);
    }

    public RunException(String message, Throwable cause) {
        super(message, cause);
    }

    public RunException(Throwable cause) {
        super(cause);
    }

    protected RunException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
