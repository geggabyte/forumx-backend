package com.noodlesscoders.forumxbackend.resource;

public class ReplyObject {

    private boolean success;

    private Object response;

    public ReplyObject(boolean success) {
        this.success = success;
    }

    public ReplyObject(boolean success, Object response) {
        this.success = success;
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
