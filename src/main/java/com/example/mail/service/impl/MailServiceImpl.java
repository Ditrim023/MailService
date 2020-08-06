package com.example.mail.service.impl;

import com.example.mail.entity.Mail;
import com.example.mail.exeption.MailNotExistException;
import com.example.mail.exeption.MailUserNotExistException;
import com.example.mail.exeption.QueryNotExecuteException;
import com.example.mail.security.MailUserService;
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
    private MailUserService mailUserService = new MailUserServiceImpl();
    private static final String GET_ALL_MAIL = "SELECT * FROM MAIL ORDER BY DATE_CREATE DESC limit 20";
    private static final String GET_MAIL = "SELECT * FROM MAIL WHERE MAIL_ID = ?";
    private static final String GET_ALL_MAIL_BY_OWNER = "SELECT * FROM MAIL where owner = ? ORDER BY DATE_CREATE DESC limit 20";
    private static final String DELETE_MAIL_BY_ID = "DELETE FROM MAIL where MAIL_ID = ?";
    private static final String CREATE_LETTERS = "insert into mail (owner,receiver, author,mail_type , theme, date_create,text) values (?,?,?,?,?,CURRENT_TIMESTAMP,?)";

    @Override
    public Mail getMail(String mailId) {
        Connection connection = ConnectionToDB.getDBConnection();
        Mail mail;
        try {
            PreparedStatement ps = connection.prepareStatement(GET_MAIL);
            ps.setInt(1, Integer.parseInt(mailId));
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                mail = extractMail(result);
                result.close();
            } else {
                throw new MailNotExistException();
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }
        return mail;
    }

    @Override
    public void createLetters(String owner, String receivers, String theme, String text) {
        String[] receiver = receivers.split(",");
        Connection connection = ConnectionToDB.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(CREATE_LETTERS);
            for (int i = 0; i < receiver.length; i++){
                if (mailUserService.findByUsername(receiver[i]).isEmpty()) {
                    throw new MailUserNotExistException(receiver[i]);
                }
//                create letter to us
                ps.setString(1, owner);
                ps.setString(2, receiver[i]);
                ps.setString(3, owner);
                ps.setString(4, "OOUGOING");
                ps.setString(5, theme);
                ps.setString(6, text);
                ps.execute();
//                send copy to companion
                ps.setString(1, receiver[i]);
                ps.setString(2, receiver[i]);
                ps.setString(3, owner);
                ps.setString(4, "INCOMIG");
                ps.setString(5, theme);
                ps.setString(6, text);
                ps.execute();
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }
    }

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
            throw new QueryNotExecuteException();
        }
        return mailList;
    }

    @Override
    public List<Mail> findAllByOwner(String username) {
        List<Mail> mailList = new ArrayList<>();
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
        String owner = rs.getString("owner");
        mail.setOwner(owner);
        mail.setCompanion(getCompanion(owner, rs.getString("author"), rs.getString("receiver")));
        mail.setMailType(rs.getString("MAIL_TYPE"));
        mail.setTheme(rs.getString("THEME"));
        mail.setText(rs.getString("TEXT"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        mail.setDateCreate(formatter.format(rs.getTimestamp("DATE_CREATE")));
        return mail;
    }

    private String getCompanion(String owner, String author, String receiver) {
        String result;
        if (author.equals(owner)) {
            result = receiver;
        } else {
            result = author;
        }
        return result;
    }
}
