package com.example.mail.service;

import com.example.mail.dao.GeneralDAO;
import com.example.mail.utils.FileReader;

public class DDLService {
    private static final String FILE_PATH_CREATE = "sql/create_tables.sql";
    private static final String FILE_PATH_DROP = "sql/drop_tables.sql";
    private FileReader fileReader = new FileReader();
    private GeneralDAO ddlDao = new GeneralDAO();

    public void createTables() {
        ddlDao.executeScript(fileReader.read(FILE_PATH_CREATE));
    }

    public void deleteTables() {
        ddlDao.executeScript(fileReader.read(FILE_PATH_DROP));
    }

}
