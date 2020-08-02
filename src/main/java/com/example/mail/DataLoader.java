package com.example.mail;


import com.example.mail.service.DDLService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Nikita Krutoguz
 */
@Component
public class DataLoader implements ApplicationRunner {
    private DDLService ddlService = new DDLService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ddlService.createTables();
        ddlService.fillMailTable();
        ddlService.fillTableUsers();
    }
}



