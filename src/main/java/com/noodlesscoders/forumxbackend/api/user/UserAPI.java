package com.noodlesscoders.forumxbackend.api.user;

import com.noodlesscoders.forumxbackend.api.ApiException;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;

import java.util.List;
import java.util.Set;

public interface UserAPI {

    void registerUser(UserOB userOB) throws ApiException;

    void login(UserOB userOB) throws ApiException;

    List<UserOB> getAll();

    Set<UserOB> getAllByIds(Set<Long> ids);

    Long getUserIdByName(String userName);
}
