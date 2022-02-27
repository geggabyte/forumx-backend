package com.noodlesscoders.forumxbackend.resource.controller.user;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import com.noodlesscoders.forumxbackend.resource.controller.ErrorIO;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;
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
        boolean result = userAPI.login(user);
        if (!result) {
            logger.error(UUID.randomUUID() + ": Error was captured");
            model.addAttribute("error", new ErrorIO(true, "Error was captured"));
            return "user_login";
        }
        model.addAttribute("loginStatus", true);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("message", new MessageIO());
        try {
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            logger.error(UUID.randomUUID() + ": " + e.getMessage(), e);
        }
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
        boolean result = userAPI.registerUser(user);
        if (!result) {
            logger.error(UUID.randomUUID() + ": Error was captured");
            model.addAttribute("error", new ErrorIO(true, "Error was captured"));
            return "user_register";
        }
        model.addAttribute("loginStatus", true);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("message", new MessageIO());
        try {
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            logger.error(UUID.randomUUID() + ": " + e.getMessage(), e);
        }
        return "message_chat";
    }

    @GetMapping("/all")
    public String getAllUser(Model model) {
        model.addAttribute("userList", userAPI.getAll());
        return "user_list";
    }
}
