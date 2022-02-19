package com.noodlesscoders.forumxbackend.api.message;

import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;

import java.util.List;

public interface MessageAPI {
    boolean sendMessage();

    List<MessageIO> readAll()  throws Exception;
}
