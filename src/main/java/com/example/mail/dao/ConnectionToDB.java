package com.example.mail.dao;


import com.example.mail.exeption.ConnectionNotCreatedException;
import com.example.mail.exeption.PropertiesFileException;
import com.example.mail.utils.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionToDB {
    private static final String DB_FILE = "application.properties";
    private static final String DB_DRIVER = "db.driver";
    private static final String DB_CONNECTION = "db.url";
    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";
    private static FileReader fileReader = new FileReader();

    public static Connection getDBConnection() {
        Connection dbConnection;
        Properties properties = readProp();
        try {
            Class.forName(properties.getProperty(DB_DRIVER));
            dbConnection = DriverManager.getConnection(
                    properties.getProperty(DB_CONNECTION),
                    properties.getProperty(DB_USER),
                    properties.getProperty(DB_PASSWORD));
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionNotCreatedException();
        }
        return dbConnection;
    }


    private static Properties readProp() {
        Properties property;
        try (InputStream inputStream = fileReader.readAsStream(DB_FILE)) {
            property = new Properties();
            property.load(inputStream);
        } catch (IOException e) {
            throw new PropertiesFileException();
        }

        return property;
    }
}
