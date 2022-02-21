package com.noodlesscoders.forumxbackend;

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

    @Autowired
    private JavaMailSender mailSender;

    @Value("${privateMail}")
    private String privateMail;

    public static void main(String[] args) {
        SpringApplication.run(ForumxBackendApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendStartedMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(privateMail);
        message.setSubject("Application status");
        message.setText("Forumx is up and running");
        mailSender.send(message);
        System.out.println("---------Message send---------");
    }

}
