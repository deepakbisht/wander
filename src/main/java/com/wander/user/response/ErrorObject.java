package com.wander.user.response;

public class ErrorObject {

    private String errorCode;
    private String errorMessage;

    public ErrorObject(String errorCode, String errorMessage, Object errorObject) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;

    }

    public ErrorObject(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
