package com.noodlesscoders.forumxbackend.resource.controller;

public class ErrorIO {

    private boolean isError;

    private String message;

    public ErrorIO(boolean isError) {
        this.isError = isError;
    }

    public ErrorIO(boolean isError, String message) {
        this.isError = isError;
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
