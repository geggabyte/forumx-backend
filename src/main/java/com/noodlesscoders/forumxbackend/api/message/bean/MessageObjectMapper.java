package com.noodlesscoders.forumxbackend.api.message.bean;

import com.noodlesscoders.forumxbackend.api.user.bean.UserOB;
import com.noodlesscoders.forumxbackend.repository.message.bean.MessageEntity;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MessageObjectMapper {

    public static List<MessageOB> mapMessageList(List<MessageEntity> source) {
        return source.stream().sorted(Comparator.comparing(MessageEntity::getCreated).reversed()).map(MessageObjectMapper::mapMessage).collect(Collectors.toList());
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
            result.setCreateTime(new SimpleDateFormat("yy-MM-dd HH:mm").format(message.getCreateTime()));
            return result;
        }
        return null;
    }

    public static MessageEntity mapMessage(MessageOB source) {
        MessageEntity result = new MessageEntity();
        if (source == null)
            return result;
        result.setId(source.getId());
        result.setUserId(source.getUserID());
        result.setMessage(source.getMessage());
        return result;
    }

    public static MessageOB mapMessage(MessageIO source, Long userId) {
        MessageOB result = new MessageOB();
        if (source == null)
            return result;
        result.setUserID(userId);
        result.setMessage(source.getMessage());
        return result;
    }
}
