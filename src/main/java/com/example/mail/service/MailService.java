package com.example.mail.service;

import com.example.mail.entity.Mail;
import com.example.mail.entity.MailView;

import java.util.List;

public interface MailService {
    void createLetters(String author,String receiver,String theme,String text);
    List<MailView> getAllMail();
    List<MailView> findAllByOwner(String username);
    void deleteMail(String mailId);
}
