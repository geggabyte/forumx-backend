package com.noodlesscoders.forumxbackend.api.user.bean;

import com.noodlesscoders.forumxbackend.api.ApiException;
import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.exception.LoginCredentialException;
import com.noodlesscoders.forumxbackend.api.user.bean.exception.NoUserException;
import com.noodlesscoders.forumxbackend.api.user.bean.exception.RegisterPasswordException;
import com.noodlesscoders.forumxbackend.api.user.bean.exception.RegisterUserNameException;
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
    public void registerUser(UserOB user) throws ApiException {
        checkCredentials(user);
        userRepository.save(mapUser(user));
    }

    private void checkCredentials(UserOB source) throws ApiException {
        if (source.getUserName().isEmpty() || source.getUserName().length() < 4)
            throw new RegisterUserNameException();
        if (source.getPassword().isEmpty() || source.getPassword().length() < 6)
            throw new RegisterPasswordException();
    }

    @Override
    public void login(UserOB user) throws ApiException {
        UserEntity userEntity = userRepository.findOneByUserName(user.getUserName());
        if (userEntity == null)
            throw new NoUserException(user.getUserName());
        UserOB dbUser = mapUser(userEntity);
        if (!user.getPassword().equals(dbUser.getPassword()))
            throw new LoginCredentialException();
    }

    @Override
    public List<UserOB> getAll() {
        return mapPublicUserList(userRepository.findAll());
    }

    @Override
    public Set<UserOB> getAllByIds(Set<Long> ids) {
        Set<UserOB> users = new HashSet<>();
        for (Long i : ids) {
            UserEntity u = userRepository.findOneById(i);
            if (u != null)
                users.add(mapUser(u));
        }
        return users;
    }

    @Override
    public Long getUserIdByName(String userName) {
        return userRepository.findOneByUserName(userName).getId();
    }

    private List<UserOB> mapPublicUserList(List<UserEntity> source) {
        return source.stream().map(this::mapPublicUser).collect(Collectors.toList());
    }

    private UserOB mapPublicUser(UserEntity source) {
        UserOB result = new UserOB();
        result.setId(source.getId());
        result.setUserName(source.getUserName());
        return result;
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
