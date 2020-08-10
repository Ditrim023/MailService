package com.example.mail.exeption;

/**
 * @author Nikita Krutoguz
 */
public class QueryNotExecuteException extends RuntimeException{
    public QueryNotExecuteException(Throwable cause) {
        super(cause);
    }
}
