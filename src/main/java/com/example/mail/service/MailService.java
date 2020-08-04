package com.example.mail.service;

import com.example.mail.entity.Mail;

import java.util.List;

public interface MailService {
    List<Mail> getAllMail();
    void deleteMail(String mailId);
}
