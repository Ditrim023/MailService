package com.example.mail.exeption;

public class MailNotExistException extends RuntimeException {
    public MailNotExistException(Throwable cause) {
        super(cause);
    }

    public MailNotExistException() {
    }
}
