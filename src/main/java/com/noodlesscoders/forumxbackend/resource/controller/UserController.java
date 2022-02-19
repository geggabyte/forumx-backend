package com.noodlesscoders.forumxbackend.resource.controller;

import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import org.apache.catalina.User;
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
        model.addAttribute("errorStatus", false);
        return "user_login";
    }

    @PostMapping("/login/result")
    public String loginResult(@ModelAttribute("user") UserOB user, Model model) {
        boolean result = userAPI.login(user);
        if (!result) {
            model.addAttribute("errorStatus", true);
            model.addAttribute("errorMessage", "Error was captured");
            return "user_login";
        }
        model.addAttribute("loginStatus", result);
        return "user_login_result";
    }

    @GetMapping("/register")
    public String registerPager(Model model) {
        model.addAttribute("errorStatus", false);
        model.addAttribute("user", new UserOB());
        return "user_register";
    }

    @PostMapping("/register/result")
    public String registerResult(@ModelAttribute("user") UserOB user, Model model) {
        boolean result = userAPI.registerUser(user);
        if (!result) {
            model.addAttribute("errorStatus", true);
            model.addAttribute("errorMessage", "Error was captured");
            return "user_register";
        }
        model.addAttribute("registerStatus", result);
        return "user_register_result";
    }

    @GetMapping("/all")
    public String getAllUser(Model model) {
        model.addAttribute("userList", userAPI.getAll());
        return "user_List";
    }
}
