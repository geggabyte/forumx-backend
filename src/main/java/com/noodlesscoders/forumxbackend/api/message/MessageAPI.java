package com.noodlesscoders.forumxbackend.api.message;

import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;
import com.noodlesscoders.forumxbackend.resource.rest.message.bean.MessageAO;

import java.util.List;

public interface MessageAPI {
    void sendMessage(MessageIO message) throws Exception;

    void sendMessage(MessageAO messageAO) throws Exception;

    List<MessageIO> readAll() throws Exception;
}
