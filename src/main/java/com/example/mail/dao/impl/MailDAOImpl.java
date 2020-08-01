package com.example.mail.dao.impl;

import com.example.mail.dao.ConnectionToDB;
import com.example.mail.dao.MailDAO;
import com.example.mail.entity.Mail;
import com.example.mail.exeption.QueryNotExecuteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MailDAOImpl implements MailDAO {
    private static final String GET_ALL_MAIL = "SELECT * FROM MAIL";

    @Override
    public List<Mail> getAllMail() {
             List<Mail> mailList = new ArrayList<>();
        Connection connection = ConnectionToDB.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_MAIL);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                mailList.add((extractMail(rs)));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        System.out.println(mailList.size());
        return mailList;
    }

    private Mail extractMail(ResultSet rs) throws SQLException {
        Mail mail = new Mail();
        mail.setId(rs.getInt("MAIL_ID"));
        mail.setFromWho(rs.getString("TO_WHO"));
        mail.setToWho(rs.getString("FROM_WHO"));
        mail.setTheme(rs.getString("THEME"));
        mail.setText(rs.getString("TEXT"));
        return mail;
    }

}
