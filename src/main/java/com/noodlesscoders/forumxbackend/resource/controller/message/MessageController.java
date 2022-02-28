package com.noodlesscoders.forumxbackend.resource.controller.message;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.resource.controller.ErrorIO;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;
import com.noodlesscoders.forumxbackend.resource.controller.user.bean.UserIO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageAPI messageAPI;

    @GetMapping("/all")
    public String getAllMessages(Model model) {
        try {
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            model.addAttribute("error", new ErrorIO(true, e.getMessage()));
        }
        model.addAttribute("error", new ErrorIO(false));
        return "message_all";
    }

    @PostMapping("/chat")
    public String chatting(@ModelAttribute("currentUser") UserIO user, Model model) {
        try {
            if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getMessage())) {
                messageAPI.sendMessage(new MessageIO(user.getUserName(), user.getMessage()));
            }
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("error", new ErrorIO(true, e.getMessage()));
        }
        if (!user.getLoginStatus()) {
            model.addAttribute("error", new ErrorIO(true, "No auth"));
        }
        model.addAttribute("error", new ErrorIO(false));
        model.addAttribute("currentUser", new UserIO(user.getLoginStatus(), user.getUserName()));
        return "message_chat";
    }

    @GetMapping("/chat")
    public String chatting(Model model) {
        try {
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            model.addAttribute("error", new ErrorIO(true, e.getMessage()));
        }
        model.addAttribute("error", new ErrorIO(true, "noAuth"));
        return "message_chat";
    }
}