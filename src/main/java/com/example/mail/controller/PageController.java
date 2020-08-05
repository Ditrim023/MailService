package com.example.mail.controller;

import com.example.mail.entity.MailDto;
import com.example.mail.service.MailService;
import com.example.mail.service.impl.MailServiceImpl;
import com.example.mail.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    private MailService mailService = new MailServiceImpl();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/mails")
    public String mails(final Model model) {
        model.addAttribute("currentUserName", Util.getAuthorizedUserName());
        model.addAttribute("mails", mailService.findAllByOwner(Util.getAuthorizedUserName()));
        return "mails";
    }

    @DeleteMapping("/mail/{mailId}")
    @ResponseBody
    public void deleteById(@PathVariable String mailId) {
        mailService.deleteMail(mailId);
    }

    @PostMapping("/mail")
    @ResponseBody
    public void sendMessage(@RequestBody MailDto newMail) {
        System.out.println(newMail);
    }
}