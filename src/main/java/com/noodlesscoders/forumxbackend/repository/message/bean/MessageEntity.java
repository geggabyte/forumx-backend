package com.noodlesscoders.forumxbackend.repository.message.bean;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "message")
    private String message;

    @GeneratedValue
    @Column(name = "created")
    private Timestamp created;

    public MessageEntity() {
    }

    public MessageEntity(Integer id, Integer userId, String message, Timestamp created) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
