package com.example.mail.service;

import com.example.mail.entity.Mail;

import java.util.List;

public interface MailService {
    List<Mail> getSearchMail(String owner, String search);

    Mail getMail(String mailId);

    void createLetters(String owner, String receivers, String theme, String text);

    List<Mail> getAllMail();

    List<Mail> findAllByOwner(String username);

    void deleteMail(String mailId);
}
