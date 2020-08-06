package com.example.mail.controller;

import com.example.mail.entity.Mail;
import com.example.mail.exeption.MailNotExistException;
import com.example.mail.exeption.MailUserNotExistException;
import com.example.mail.service.MailService;
import com.example.mail.service.impl.MailServiceImpl;
import com.example.mail.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/new-mail")
    public String newMail() {
        return "new-mail";
    }

    @GetMapping(value = "/403")
    public String error() {
        return "errors/403";
    }

    @GetMapping("/answer/{mailId}")
    public String answer(@PathVariable String mailId, Model model) {
        try {
            Mail mail = mailService.getMail(mailId);
            model.addAttribute("mail", mail);
        } catch (MailUserNotExistException e) {
            return "errors/mail-not-exist.html";
        }
        return "answer";
    }

    @GetMapping("/settings")
    public String settings( Model model) {
        model.addAttribute("username", Util.getAuthorizedUserName());
        return "settings";
    }

    @GetMapping("mail/search")
    public String search(@RequestParam String search, Model model) {
        model.addAttribute(MAILS, mailService.getSearchMail(Util.getAuthorizedUserName(), search));
        return MAILS;
    }

    @GetMapping("/mails")
    public String mails(final Model model) {
        model.addAttribute("currentUserName", Util.getAuthorizedUserName());
        model.addAttribute(MAILS, mailService.findAllByOwner(Util.getAuthorizedUserName()));
        return MAILS;
    }

    @GetMapping("/mail/{mailId}")
    public String mail(@PathVariable String mailId, final Model model) {
        try {
            Mail mail = mailService.getMail(mailId);
            model.addAttribute("mail", mail);
        } catch (MailNotExistException e) {
            return "errors/mail-not-exist.html";
        }
        return "mail";
    }

    @PostMapping(value = "/mail/create")
    public String sendMessage(@RequestParam String receivers, @RequestParam String theme, @RequestParam String text) {
        try {
            mailService.createLetters(Util.getAuthorizedUserName(), receivers, theme, text);
        } catch (MailUserNotExistException e) {
            return "errors/user-not-exist.html";
        }
        return "redirect:/mails";
    }

}