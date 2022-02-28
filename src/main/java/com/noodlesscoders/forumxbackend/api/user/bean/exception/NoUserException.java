package com.noodlesscoders.forumxbackend.api.user.bean.exception;

import com.noodlesscoders.forumxbackend.api.ApiException;

public class NoUserException extends ApiException {
    public NoUserException(String userName) {
        super("No user found with user name: " + userName);
    }
}
