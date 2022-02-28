package com.noodlesscoders.forumxbackend.resource.controller.user;

import com.noodlesscoders.forumxbackend.api.ApiException;
import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import com.noodlesscoders.forumxbackend.resource.controller.ErrorIO;
import com.noodlesscoders.forumxbackend.resource.controller.user.bean.UserIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAPI userAPI;

    @Autowired
    private MessageAPI messageAPI;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new UserOB());
        model.addAttribute("error", new ErrorIO(false));
        logger.debug("User opened login page");
        return "user_login";
    }

    @PostMapping("/login/result")
    public String loginResult(@ModelAttribute("user") UserOB user, Model model) {
        try {
            userAPI.login(user);
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            logger.error(UUID.randomUUID() + ": " + e.getMessage(), e);
            model.addAttribute("error", new ErrorIO(true, e.getMessage()));
            return "user_login";
        }
        model.addAttribute("error", new ErrorIO(false));
        model.addAttribute("currentUser", new UserIO(true, user.getUserName()));
        return "message_chat";
    }

    @GetMapping("/register")
    public String registerPager(Model model) {
        model.addAttribute("error", new ErrorIO(false));
        model.addAttribute("user", new UserOB());
        return "user_register";
    }

    @PostMapping("/register/result")
    public String registerResult(@ModelAttribute("user") UserOB user, Model model) {
        try {
            userAPI.registerUser(user);
            model.addAttribute("messages", messageAPI.readAll());
        } catch (ApiException e) {
            logger.error(UUID.randomUUID() + ": " + e.getMessage(), e);
            model.addAttribute("error", new ErrorIO(true, e.getMessage()));
            return "user_register";
        } catch (Exception e) {
            logger.error(UUID.randomUUID() + ": " + e.getMessage(), e);
        }
        model.addAttribute("error", new ErrorIO(false));
        model.addAttribute("currentUser", new UserIO(true, user.getUserName()));
        return "message_chat";
    }

    @GetMapping("/all")
    public String getAllUser(Model model) {
        model.addAttribute("userList", userAPI.getAll());
        return "user_list";
    }
}
