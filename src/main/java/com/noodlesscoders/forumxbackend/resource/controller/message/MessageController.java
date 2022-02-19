package com.noodlesscoders.forumxbackend.resource.controller.message;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageAPI messageAPI;

    @GetMapping("/all")
    public String getAllMessgaes(Model model) {
        try {
            model.addAttribute("messages", messageAPI.readAll());
        } catch (Exception e) {
            model.addAttribute("errorStatus", true);
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "message_all";
    }
}
