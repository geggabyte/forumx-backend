package com.noodlesscoders.forumxbackend.resource.rest.user;

import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import com.noodlesscoders.forumxbackend.resource.ReplyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserAPI userAPI;

    @GetMapping("/list")
    public ReplyObject getAll() {
        try {
            return new ReplyObject(true, userAPI.getAll());
        } catch (Exception e) {
            return new ReplyObject(false);
        }
    }

    @PostMapping("/register")
    public ReplyObject registerUser(UserOB userOB) {
        return new ReplyObject(userAPI.registerUser(userOB));
    }
}
