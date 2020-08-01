package com.example.mail;

import com.example.mail.service.DDLService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailApplication {
    public static void main(String[] args) {
//        DDLService ddlService = new DDLService();
//        ddlService.createTables();
        SpringApplication.run(MailApplication.class, args);
//        ddlService.deleteTables();
    }
}
