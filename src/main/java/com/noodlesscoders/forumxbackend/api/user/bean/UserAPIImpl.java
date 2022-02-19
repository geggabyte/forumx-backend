package com.noodlesscoders.forumxbackend.api.user.bean;

import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.repository.user.UserRepository;
import com.noodlesscoders.forumxbackend.repository.user.bean.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserAPIImpl implements UserAPI {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registerUser(UserOB user) {
        try {
            userRepository.save(mapUser(user));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean login(UserOB user) {
        UserEntity userEntity = userRepository.findOneByUserName(user.getUserName());
        if (userEntity == null)
            return false;
        UserOB dbUser = mapUser(userEntity);
        return user.getPassword().equals(dbUser.getPassword());
    }

    @Override
    public List<UserOB> getAll() {
        return mapUserList(userRepository.findAll());
    }

    @Override
    public Set<UserOB> getAllByIds(Set<Integer> ids) {
        Set<UserOB> users = new HashSet<>();
        for (Integer i : ids) {
            UserEntity u = userRepository.findOneById(i);
            if (u != null)
                users.add(mapUser(u));
        }
        return users;
    }

    @Override
    public Integer getUserIdByName(String userName) {
        return userRepository.findOneByUserName(userName).getId();
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
