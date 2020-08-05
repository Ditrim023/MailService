package com.example.mail.controller;

import com.example.mail.entity.MailUser;
import com.example.mail.entity.Mail;
import com.example.mail.security.MailUserService;
import com.example.mail.service.MailService;
import com.example.mail.service.impl.MailServiceImpl;
import com.example.mail.service.impl.MailUserServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MailRestController {
    private MailService mailService = new MailServiceImpl();
    private MailUserService mailUserService = new MailUserServiceImpl();

    @GetMapping("/api/mails")
    public List<Mail> getAllMail() {
        return mailService.getAllMail();
    }

    @DeleteMapping("/api/mail/{mailId}")
    public void deleteByApiId(@PathVariable String mailId) {
        mailService.deleteMail(mailId);
    }

    @GetMapping("/api/users")
    public List<MailUser> getAllMailUsers() {
        return mailUserService.getAllUsers();
    }
}
