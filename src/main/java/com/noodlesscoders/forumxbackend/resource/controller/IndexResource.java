package com.noodlesscoders.forumxbackend.resource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexResource {
    @GetMapping
    public String index() {
        return "main_page";
    }
}
