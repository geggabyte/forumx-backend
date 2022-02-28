package com.noodlesscoders.forumxbackend.api.user.bean.exception;

import com.noodlesscoders.forumxbackend.api.ApiException;

public class RegisterUserNameException extends ApiException {
    public RegisterUserNameException() {
        super("User name must be longer or equal to  4 letters");
    }

    public RegisterUserNameException(String message) {
        super(message);
    }

    public RegisterUserNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
