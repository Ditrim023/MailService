package com.example.mail.service.impl;

import com.example.mail.entity.Mail;
import com.example.mail.entity.MailView;
import com.example.mail.exeption.QueryNotExecuteException;
import com.example.mail.service.ConnectionToDB;
import com.example.mail.service.MailService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MailServiceImpl implements MailService {
    private static final String GET_ALL_MAIL = "SELECT * FROM MAIL ORDER BY DATE_CREATE DESC limit 20";
    private static final String GET_ALL_MAIL_BY_OWNER = "SELECT * FROM MAIL where owner = ? ORDER BY DATE_CREATE DESC limit 20";
    private static final String DELETE_MAIL_BY_ID = "DELETE FROM MAIL where MAIL_ID = ?";
    private static final String CREATE_LETTERS = "";

    @Override
    public void createLetters(String author, String receiver, String theme, String text) {

    }

    @Override
    public List<MailView> getAllMail() {
        List<MailView> mailList = new ArrayList<>();
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
    public List<MailView> findAllByOwner(String username) {
        List<MailView> mailList = new ArrayList<>();
        Connection connection = ConnectionToDB.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_MAIL_BY_OWNER);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mailList.add((extractMail(rs)));
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }
        return mailList;
    }

    @Override
    public void deleteMail(String mailId) {
        System.out.println(mailId);
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


    private MailView extractMail(ResultSet rs) throws SQLException {
        MailView mail = new MailView();
        mail.setId(rs.getInt("MAIL_ID"));
        String owner = rs.getString("owner");
        mail.setOwner(owner);
        mail.setCompanion(getCompanion(owner,rs.getString("author"),rs.getString("receiver")));
        mail.setMailType(rs.getString("MAIL_TYPE"));
        mail.setTheme(rs.getString("THEME"));
        mail.setText(rs.getString("TEXT"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        mail.setDateCreate(formatter.format(rs.getTimestamp("DATE_CREATE")));
        return mail;
    }

    private String getCompanion(String owner,String author,String receiver) {
       String result;
       if (author.equals(owner)){
           result = receiver;
       }else{
           result = author;
       }
       return result;
    }
}
