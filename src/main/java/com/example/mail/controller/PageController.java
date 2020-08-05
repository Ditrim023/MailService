package com.example.mail.controller;

import com.example.mail.service.MailService;
import com.example.mail.service.impl.MailServiceImpl;
import com.example.mail.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("mails", mailService.findAllByOwner(Util.getAuthorizedUserName()));
        return "mails";
    }

}