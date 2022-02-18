package com.noodlesscoders.forumxbackend.resource.controller;

import com.noodlesscoders.forumxbackend.api.TestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("data")
public class TestController {

    @Autowired
    TestAPI testAPI;

    @GetMapping("/show-all")
    public String showAll(Model model) {
        model.addAttribute("testList", testAPI.findAll());
        return "test_list";
    }

}
