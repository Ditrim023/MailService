package com.example.mail.service;

import com.example.mail.entity.Mail;

import java.util.List;

public interface MailService {
    void createLetters(String author,String receiver,String theme,String text);
    List<Mail> getAllMail();
    List<Mail> findAllByOwner(String username);
    void deleteMail(String mailId);
}
