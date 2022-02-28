package com.noodlesscoders.forumxbackend.resource.controller.message.bean;

public class MessageIO {

    private String userName;

    private String message;

    private String createTime;


    public MessageIO(){

    }

    public MessageIO(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MessageIO{" +
                "userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
