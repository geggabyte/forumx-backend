package com.noodlesscoders.forumxbackend.resource.controller.message;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.resource.controller.ErrorIO;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;
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
        return "message_all";
    }

    @PostMapping("/chat")
    public String chatting(@ModelAttribute("message") MessageIO message, Model model) {
        try {
            if (!StringUtils.isEmpty(message.getUserName()) && !StringUtils.isEmpty(message.getMessage())) {
                messageAPI.sendMessage(message);
            }
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("error", new ErrorIO(true, e.getMessage()));
        }
        if (!message.getLoginStatus()) {
            model.addAttribute("error", new ErrorIO(true, "No auth"));
        }
        model.addAttribute("loginStatus", message.getLoginStatus());
        model.addAttribute("userName", message.getUserName());
        model.addAttribute("message", new MessageIO());
        return "message_chat";
    }

    @GetMapping("/chat")
    public String chatting(Model model) {
        try {
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            model.addAttribute("errorStatus", true);
            model.addAttribute("errorMessage", e.getMessage());
        }
        model.addAttribute("errorStatus", true);
        model.addAttribute("errorMessage", "noAuth");
        return "message_chat";
    }
}