package com.example.mail.service.impl;

import com.example.mail.service.ConnectionToDB;
import com.example.mail.service.MailService;
import com.example.mail.entity.Mail;
import com.example.mail.exeption.QueryNotExecuteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MailServiceImpl implements MailService {
    private static final String GET_ALL_MAIL = "SELECT * FROM MAIL ORDER BY DATE_CREATE DESC limit 20";
    private static final String DELETE_MAIL_BY_ID = "DELETE FROM MAIL where MAIL_ID = ?";

    @Override
    public List<Mail> getAllMail() {
        List<Mail> mailList = new ArrayList<>();
        Connection connection = ConnectionToDB.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_MAIL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mailList.add((extractMail(rs)));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return mailList;
    }

    @Override
    public void deleteMail(String mailId) {
        Connection connection = ConnectionToDB.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_MAIL_BY_ID);
            ps.setInt(1, Integer.parseInt(mailId));
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }
    }


    private Mail extractMail(ResultSet rs) throws SQLException {
        Mail mail = new Mail();
        mail.setId(rs.getInt("MAIL_ID"));
        mail.setFromWho(rs.getString("TO_WHO"));
        mail.setToWho(rs.getString("FROM_WHO"));
        mail.setTheme(rs.getString("THEME"));
        mail.setText(rs.getString("TEXT"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        mail.setDateCreate(formatter.format(rs.getTimestamp("DATE_CREATE")));
        return mail;
    }
}