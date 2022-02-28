package com.noodlesscoders.forumxbackend.api;

public class ApiException extends Exception{
    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
