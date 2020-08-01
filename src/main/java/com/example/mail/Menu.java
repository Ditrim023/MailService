package com.example.mail;

import com.example.mail.dao.MailDAO;
import com.example.mail.dao.impl.MailDAOImpl;
import com.example.mail.entity.Mail;

import java.util.List;

public class Menu {
    private MailDAO mailDAO = new MailDAOImpl();
    public void run(){
        List<Mail> list = mailDAO.getAllMail();
        System.out.println(list.size());
    }
}
