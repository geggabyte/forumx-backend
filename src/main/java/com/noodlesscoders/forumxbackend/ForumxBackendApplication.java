package com.noodlesscoders.forumxbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class ForumxBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumxBackendApplication.class, args);
    }

}
