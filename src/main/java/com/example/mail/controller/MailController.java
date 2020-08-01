package com.example.mail.controller;

import com.example.mail.dao.ConnectionToDB;
import com.example.mail.dao.MailDAO;
import com.example.mail.dao.impl.MailDAOImpl;
import com.example.mail.entity.Mail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
public class MailController {
    private MailDAO mailDAO = new MailDAOImpl();


    @GetMapping("/api/mails")
    public List<Mail> getAllMail() throws SQLException {
        return mailDAO.getAllMail();
    }


    public void createUser(){

    }
}
