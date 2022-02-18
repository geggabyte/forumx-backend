package com.noodlesscoders.forumxbackend.resource.rest.test;

import com.noodlesscoders.forumxbackend.api.test.TestAPI;
import com.noodlesscoders.forumxbackend.resource.ReplyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class TestResource {

    @Autowired
    private TestAPI testAPI;

    @GetMapping("/all")
    public ReplyObject getAll() {
        return new ReplyObject(true, testAPI.findAll());
    }
}
