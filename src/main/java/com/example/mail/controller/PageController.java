package com.example.mail.controller;

import com.example.mail.dao.MailDAO;
import com.example.mail.dao.impl.MailDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    private MailDAO mailDAO = new MailDAOImpl();

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String mails(final Model model) {
        model.addAttribute("mails", mailDAO.getAllMail());
        return "mails";
    }
}
