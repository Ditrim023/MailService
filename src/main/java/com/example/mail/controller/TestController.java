package com.example.mail.controller;

import com.example.mail.dao.MailDAO;
import com.example.mail.dao.impl.MailDAOImpl;
import com.example.mail.entity.Mail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class TestController {
    private MailDAO mailDAO = new MailDAOImpl();

    @GetMapping("/api/mail")
    public Mail getFirstMail() throws SQLException {
        return mailDAO.getAllMail().get(0);
    }
}
