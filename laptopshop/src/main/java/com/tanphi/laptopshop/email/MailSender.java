package com.tanphi.laptopshop.email;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.mail.MessagingException;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailSender {
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    @Value("${spring.mail.username}")
    private String username;

    @SneakyThrows
    public void sendMessageHtml(String to, String subject, String template, Map<String, Object> attributes) throws MessagingException {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(attributes);
        if(!thymeleafTemplateEngine.isInitialized())
        {
            thymeleafTemplateEngine.addDialect(new Java8TimeDialect());
        }
        String htmlBody = thymeleafTemplateEngine.process(template, thymeleafContext);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(username);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        mailSender.send(message);
    }
}
