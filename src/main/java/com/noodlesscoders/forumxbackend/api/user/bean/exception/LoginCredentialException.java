package com.noodlesscoders.forumxbackend.api.user.bean.exception;

import com.noodlesscoders.forumxbackend.api.ApiException;

public class LoginCredentialException extends ApiException {
    public LoginCredentialException() {
        super("User login or password isn't correct");
    }

    public LoginCredentialException(String message) {
        super(message);
    }

    public LoginCredentialException(String message, Throwable cause) {
        super(message, cause);
    }
}
