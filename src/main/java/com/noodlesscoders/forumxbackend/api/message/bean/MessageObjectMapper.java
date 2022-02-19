package com.noodlesscoders.forumxbackend.api.message.bean;

import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import com.noodlesscoders.forumxbackend.repository.message.bean.MessageEntity;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MessageObjectMapper {

    public static List<MessageOB> mapMessageList(List<MessageEntity> source) {
        return source.stream().map(MessageObjectMapper::mapMessage).collect(Collectors.toList());
    }

    public static List<MessageIO> mapMessageList(List<MessageOB> messages, Set<UserOB> users) {
        return messages.stream().map(mes -> {
            return MessageObjectMapper.mapMessage(mes, users);
        }).collect(Collectors.toList());
    }

    public static MessageOB mapMessage(MessageEntity source) {
        MessageOB result = new MessageOB();
        if (source == null)
            return result;
        result.setId(source.getId());
        result.setUserID(source.getUserId());
        result.setMessage(source.getMessage());
        result.setCreateTime(source.getCreated());
        return result;
    }

    public static MessageIO mapMessage(MessageOB message, Set<UserOB> users) {
        MessageIO result = new MessageIO();
        for (UserOB user : users) {
            if (!Objects.equals(user.getId(), message.getUserID()))
                continue;
            result.setUserName(user.getUserName());
            result.setMessage(message.getMessage());
            result.setCreateTime(message.getCreateTime());
            return result;
        }
        return null;
    }
}
