package com.noodlesscoders.forumxbackend.resource.rest.message;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.resource.ReplyObject;
import com.noodlesscoders.forumxbackend.resource.rest.message.bean.MessageAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageResource {

    @Autowired
    private MessageAPI messageAPI;

    @GetMapping("/list")
    public ReplyObject allMessages() {
        try {
            return new ReplyObject(true, messageAPI.readAll());
        } catch (Exception e) {
            return new ReplyObject(false);
        }
    }

    @PostMapping("/send")
    public ReplyObject sendMessage(MessageAO messageAO) {
        try {
            messageAPI.sendMessage(messageAO);
            return new ReplyObject(true);
        } catch (Exception e) {
            return new ReplyObject(false);
        }
    }
}
