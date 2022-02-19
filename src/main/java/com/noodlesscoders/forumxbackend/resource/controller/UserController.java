package com.noodlesscoders.forumxbackend.resource.controller;

import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAPI userAPI;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new UserOB());
        return "user_login";
    }

    @PostMapping("/login/result")
    public String loginResult(@ModelAttribute("user") UserOB user, Model model) {
        System.out.println(user);
        model.addAttribute("loginStatus", userAPI.login(user));
        return "user_login_result";
    }

    @GetMapping("/all")
    public String getAllUser(Model model) {
        model.addAttribute("userList", userAPI.getAll());
        return "user_List";
    }
}
