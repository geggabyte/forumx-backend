package com.noodlesscoders.forumxbackend.api.user;

import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;

import java.util.List;
import java.util.Set;

public interface UserAPI {

    boolean registerUser(UserOB userOB);

    boolean login(UserOB userOB);

    List<UserOB> getAll();

    Set<UserOB> getAllByIds(Set<Integer> ids);

    Integer getUserIdByName(String userName);
}
