package com.rose.crud.user.email.controller;

import com.rose.crud.user.email.entity.Email;
import com.rose.crud.user.email.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("send-email")
    public Email sendEmail(@RequestBody Email email){
        return emailService.sendEmail(email);
    }
}
