package com.noodlesscoders.forumxbackend.api.report.bean;

import com.noodlesscoders.forumxbackend.api.report.ReportAPI;
import com.noodlesscoders.forumxbackend.resource.controller.report.bean.ReportIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ReportAPIImpl implements ReportAPI {

    @Autowired
    private JavaMailSender mailSender;


    @Value("${privateMail}")
    private String privateMail;

    @Override
    public void sendReport(ReportIO report) throws NoContentException {
        if (report.getContent() == null || Objects.equals(report.getContent(), ""))
            throw new NoContentException("No content forund for repoert: " + report);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(privateMail);
        message.setSubject(report.getTopic() == null ? "Report" : report.getTopic());
        String content = report.getContent() + "\n\nFrom: " + report.getUserName() + "\nEmail: " + report.getUserEmail();
        message.setText(content);
        mailSender.send(message);
    }
}
