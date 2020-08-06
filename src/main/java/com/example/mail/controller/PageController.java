package com.example.mail.controller;

import com.example.mail.service.MailService;
import com.example.mail.service.impl.MailServiceImpl;
import com.example.mail.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    private static final String MAILS = "mails";
    private MailService mailService = new MailServiceImpl();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/mail")
    public String mail() {
        return "mail";
    }

    @GetMapping(value = "/403")
    public String error() {
        return "403";
    }

    @GetMapping("/mails")
    public String mails(final Model model) {
        model.addAttribute("currentUserName", Util.getAuthorizedUserName());
        model.addAttribute(MAILS, mailService.findAllByOwner(Util.getAuthorizedUserName()));
        return MAILS;
    }

    @PostMapping(value = "/mail/create")
    public String sendMessage(@RequestParam String receiver, @RequestParam String theme, @RequestParam String text) {
        mailService.createLetters(Util.getAuthorizedUserName(), receiver, theme, text);
        return "redirect:/mails";
    }

}