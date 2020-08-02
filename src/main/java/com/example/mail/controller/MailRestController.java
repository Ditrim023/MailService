package com.example.mail.controller;

import com.example.mail.dao.MailDAO;
import com.example.mail.dao.impl.MailDAOImpl;
import com.example.mail.entity.Mail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MailRestController {
    private MailDAO mailDAO = new MailDAOImpl();

    @GetMapping("/api/mails")
    public List<Mail> getAllMail() {
        return mailDAO.getAllMail();
    }
}
