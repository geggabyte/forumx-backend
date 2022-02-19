package com.noodlesscoders.forumxbackend.resource.controller.message.bean;

import java.util.Date;

public class MessageIO {

    private String userName;

    private String message;

    private Date createTime;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
