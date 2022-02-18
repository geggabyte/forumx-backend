package com.noodlesscoders.forumxbackend.api.user.bean;

import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.repository.user.UserRepository;
import com.noodlesscoders.forumxbackend.repository.user.bean.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserAPIImpl implements UserAPI {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(UserOB user) {
        userRepository.save(mapUser(user));
    }

    @Override
    public boolean login(UserOB userOB) {
        return false;
    }

    @Override
    public List<UserOB> getAll() {
        return mapUserList(userRepository.findAll());
    }

    private List<UserOB> mapUserList(List<UserEntity> source) {
        return source.stream().map(this::mapUser).collect(Collectors.toList());
    }

    private UserOB mapUser(UserEntity source) {
        UserOB result = new UserOB();
        result.setId(source.getId());
        result.setUserName(source.getUserName());
        result.setPassword(source.getPassword());
        return result;
    }

    private UserEntity mapUser(UserOB source) {
        UserEntity result = new UserEntity();
        result.setId(source.getId());
        result.setUserName(source.getUserName());
        result.setPassword(source.getPassword());
        return result;
    }
}
