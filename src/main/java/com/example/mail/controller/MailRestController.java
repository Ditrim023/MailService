package com.example.mail.controller;

import com.example.mail.entity.Mail;
import com.example.mail.entity.MailDto;
import com.example.mail.entity.MailUser;
import com.example.mail.security.MailUserService;
import com.example.mail.service.MailService;
import com.example.mail.service.impl.MailServiceImpl;
import com.example.mail.service.impl.MailUserServiceImpl;
import com.example.mail.utils.Util;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/mail")
//    public String sendMessage(@RequestBody MailDto newMail) {
//        mailService.createLetters(Util.getAuthorizedUserName(), newMail);
//        return "redirect:/mails";
//    }



    @DeleteMapping("/mail/{mailId}")
    public void deleteById(@PathVariable String mailId) {
        mailService.deleteMail(mailId);
    }

}
