package com.noodlesscoders.forumxbackend.api.user;

import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;

import java.util.List;

public interface UserAPI {

    void registerUser(UserOB userOB);

    boolean login(UserOB userOB);

    List<UserOB> getAll();
}
