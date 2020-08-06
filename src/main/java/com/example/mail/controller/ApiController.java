package com.example.mail.controller;

import com.example.mail.entity.Mail;
import com.example.mail.entity.MailUser;
import com.example.mail.service.MailService;
import com.example.mail.service.MailUserService;
import com.example.mail.service.impl.MailServiceImpl;
import com.example.mail.service.impl.MailUserServiceImpl;
import com.example.mail.utils.Util;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
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

    @DeleteMapping("/mail/{mailId}")
    public void deleteById(@PathVariable String mailId) {
        mailService.deleteMail(mailId);
    }

    @GetMapping("/check/role")
    public String getRole() {
        return mailUserService.getRole(Util.getAuthorizedUserName());
    }

    @PostMapping("/api/set")
    public String checkApi(@RequestBody Boolean status) {
        mailUserService.setStatus(Util.getAuthorizedUserName(), status);
        return "redirect:/mails";
    }
}
