package com.cilys.web.core.exception;

/**
 * Created by Administrator on 2024/11/21.
 */
public class EmptyException extends RunException {
    public EmptyException() {
        super();
    }

    public EmptyException(String message) {
        super(message);
    }
}
