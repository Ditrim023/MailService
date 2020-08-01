package com.example.mail;

import com.example.mail.service.DDLService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class MailApplication {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(MailApplication.class, args);
    }
}
