package com.noodlesscoders.forumxbackend.api.user.bean.exception;

import com.noodlesscoders.forumxbackend.api.ApiException;

public class RegisterPasswordException extends ApiException {
    public RegisterPasswordException() {
        super("Password must be longer or equal to 6 letters");
    }

    public RegisterPasswordException(String message) {
        super(message);
    }

    public RegisterPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
