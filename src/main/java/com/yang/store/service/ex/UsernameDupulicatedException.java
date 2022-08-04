package com.yang.store.service.ex;

public class UsernameDupulicatedException extends ServiceException{
    public UsernameDupulicatedException() {
        super();
    }

    public UsernameDupulicatedException(String message) {
        super(message);
    }

    public UsernameDupulicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDupulicatedException(Throwable cause) {
        super(cause);
    }

    protected UsernameDupulicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
