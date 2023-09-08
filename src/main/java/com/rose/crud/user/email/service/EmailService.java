package com.rose.crud.user.email.service;

import com.rose.crud.user.email.repository.EmailRepository;
import com.rose.crud.user.email.entity.Email;
import com.rose.crud.user.email.repository.EmailService1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailService1 {

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;
     @Value("odhiamborose466@gmail.com")
    private String emailFrom;

    public EmailService(JavaMailSender javaMailSender, EmailRepository emailRepository) {
        this.javaMailSender = javaMailSender;
        this.emailRepository = emailRepository;
    }

    @Override
    public Email sendEmail(Email email){
         SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
         simpleMailMessage.setFrom(emailFrom);
         simpleMailMessage.setTo(email.getEmailTo());
         simpleMailMessage.setText(email.getMessage());
         simpleMailMessage.setSubject(email.getSubject());
        javaMailSender.send(simpleMailMessage);
        emailRepository.save(email) ;
       return email;
   }




}
