package com.noodlesscoders.forumxbackend.api.message.bean;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import com.noodlesscoders.forumxbackend.repository.message.MessageRepository;
import com.noodlesscoders.forumxbackend.repository.message.bean.MessageEntity;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MessageAPIImpl implements MessageAPI {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserAPI userAPI;

    @Override
    public boolean sendMessage() {
        return false;
    }

    @Override
    public List<MessageIO> readAll() throws Exception {
        List<MessageEntity> messageEntities = messageRepository.findAll();
        if (messageEntities.get(0) == null)
            throw new Exception("No messgaes found");
        List<MessageOB> messageOBS = MessageObjectMapper.mapMessageList(messageEntities);
        Set<UserOB> users = userAPI.getAllByIds(messageOBS.stream().map(MessageOB::getUserID).collect(Collectors.toSet()));
        return MessageObjectMapper.mapMessageList(messageOBS, users);
    }
}
