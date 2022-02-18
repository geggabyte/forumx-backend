package com.noodlesscoders.forumxbackend.resource.rest.ping;

import com.noodlesscoders.forumxbackend.resource.ReplyObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingResource {
    @GetMapping
    public ReplyObject ping() {
        return new ReplyObject(true);
    }
}
