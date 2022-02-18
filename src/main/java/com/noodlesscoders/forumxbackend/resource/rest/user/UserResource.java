package com.noodlesscoders.forumxbackend.resource.rest.user;

import com.noodlesscoders.forumxbackend.resource.ReplyObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    @GetMapping("/register")
    public ReplyObject register() {

        return new ReplyObject(true);
    }
}
