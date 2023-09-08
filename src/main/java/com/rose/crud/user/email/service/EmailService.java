package com.rose.crud.user.email.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService{

    private final JavaMailSender javaMailSender;
    @Value("odhiamborose466@gmail.com")
    private String emailFrom;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(String toEmail, String subject, String text){
         SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
         simpleMailMessage.setFrom(emailFrom);
         simpleMailMessage.setTo(toEmail);
         simpleMailMessage.setText(text);
         simpleMailMessage.setSubject(subject);
        javaMailSender.send(simpleMailMessage);
   }




}
