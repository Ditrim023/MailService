package com.example.mail.service;


import com.example.mail.exeption.ConnectionNotCreatedException;
import com.example.mail.exeption.PropertiesFileException;
import com.example.mail.utils.FileReader;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class ConnectionToDB {
    private static final String DB_FILE = "application.properties";
    private static final String DB_CONNECTION = "db.url";
    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";
    private static FileReader fileReader = new FileReader();

    public static Connection getDBConnection() {
        Connection dbConnection;
        Properties properties = readProp();
        try {
            dbConnection = DriverManager.getConnection(
                    properties.getProperty(DB_CONNECTION),
                    properties.getProperty(DB_USER),
                    properties.getProperty(DB_PASSWORD));
        } catch (SQLException e) {
            throw new ConnectionNotCreatedException(e);
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
