package com.example.mail.service;

import com.example.mail.entity.Mail;
import com.example.mail.entity.MailDto;

import java.util.List;

public interface MailService {
    void createLetters(String author, MailDto mailDto);
    List<Mail> getAllMail();
    List<Mail> findAllByOwner(String username);
    void deleteMail(String mailId);
}
