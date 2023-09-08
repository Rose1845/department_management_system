package com.rose.crud.error;

public class ApiRequestHandlerException extends  RuntimeException{

    public ApiRequestHandlerException() {
        super();
    }

    public ApiRequestHandlerException(String message) {
        super(message);
    }

    public ApiRequestHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestHandlerException(Throwable cause) {
        super(cause);
    }

    protected ApiRequestHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
