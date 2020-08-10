package com.example.mail.exeption;

/**
 * @author Nikita Krutoguz
 */
public class ConnectionNotCreatedException extends RuntimeException{
    public ConnectionNotCreatedException(Throwable cause) {
        super(cause);
    }
}
