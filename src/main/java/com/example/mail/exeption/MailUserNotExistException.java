package com.example.mail.exeption;

public class MailUserNotExistException extends RuntimeException {
    public MailUserNotExistException(String message) {
        super("Непрвильное имя пользователя:" + message);
    }
}
