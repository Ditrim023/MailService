package com.example.mail.exeption;

/**
 * @author Nikita Krutoguz
 */
public class FileReadException extends RuntimeException{
    public FileReadException(){
        super("Something wrong with file");
    }
}
