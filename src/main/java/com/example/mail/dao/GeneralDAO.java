package com.example.mail.dao;

import com.example.mail.exeption.QueryNotExecuteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GeneralDAO {
    public void executeScript(String script) {
        Connection connection = ConnectionToDB.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(script);
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }
    }
}
