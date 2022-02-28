package com.noodlesscoders.forumxbackend.api.message.bean;

import com.noodlesscoders.forumxbackend.api.ApiException;
import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.api.user.UserAPI;
import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import com.noodlesscoders.forumxbackend.repository.message.MessageRepository;
import com.noodlesscoders.forumxbackend.repository.message.bean.MessageEntity;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;
import com.noodlesscoders.forumxbackend.resource.rest.message.bean.MessageAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MessageAPIImpl implements MessageAPI {

    private final Logger logger = LoggerFactory.getLogger(MessageAPIImpl.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserAPI userAPI;

    @Override
    public void sendMessage(MessageIO message) throws Exception {
        try {
            MessageOB messageOB = MessageObjectMapper.mapMessage(message, userAPI.getUserIdByName(message.getUserName()));
            messageRepository.saveAndFlush(MessageObjectMapper.mapMessage(messageOB));
        } catch (Exception e) {
            throw new Exception("Something went wrong on saving message`: " + message + "\n" + e.getMessage());
        }
    }

    @Override
    public void sendMessage(MessageAO messageAO) throws Exception {
        MessageIO messageIO = new MessageIO();
        messageIO.setUserName(messageAO.getUserName());
        messageIO.setMessage(messageAO.getMessage());
        try {
            userAPI.login(new UserOB(messageAO.getUserName(), messageAO.getPassword()));
        } catch (ApiException e) {
            logger.error(UUID.randomUUID() + ": error when sending message: " + messageIO, e);
            return;
        }
        sendMessage(messageIO);
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
