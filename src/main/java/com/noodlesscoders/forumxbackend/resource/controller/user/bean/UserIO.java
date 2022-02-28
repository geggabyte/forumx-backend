package com.noodlesscoders.forumxbackend.resource.controller.user.bean;

public class UserIO {

    private Boolean loginStatus;

    private String userName;

    private String message;

    public UserIO(){
        this.message = "";
    }

    public UserIO(Boolean loginStatus, String userName) {
        this.loginStatus = loginStatus;
        this.userName = userName;
        this.message = "";
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
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
}
