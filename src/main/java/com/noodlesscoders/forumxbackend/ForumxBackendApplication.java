package com.noodlesscoders.forumxbackend;

import com.noodlesscoders.forumxbackend.api.message.MessageAPI;
import com.noodlesscoders.forumxbackend.resource.controller.message.bean.MessageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class ForumxBackendApplication {

    private final Logger logger = LoggerFactory.getLogger(ForumxBackendApplication.class);

/*    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MessageAPI messageAPI;

    @Value("${privateMail}")
    private String privateMail;*/

    public static void main(String[] args) {
        SpringApplication.run(ForumxBackendApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendStartedMessage() {
        logger.info("-------App is up and running-------");
    }

}
