package com.example.mail.service.impl;

import com.example.mail.entity.MailUser;
import com.example.mail.exeption.MailUserNotExistException;
import com.example.mail.exeption.QueryNotExecuteException;
import com.example.mail.service.ConnectionToDB;
import com.example.mail.service.MailUserService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MailUserServiceImpl implements MailUserService {
    private static final String USER = "ROLE_USER";
    private static final String APPICALL = "ROLE_APICALL";
    private static final String GET_ROLE = "select user_role from mail_user where user_name = ?";
    private static final String SET_STATUS = "update mail_user set user_role = ? where user_name = ?";
    private static final String GET_USER_BY_USERNAME = "Select * from mail_user where user_name = ?";
    private static final String GET_ALL_USERS = "Select * from mail_user;";

    @Override
    public String getRole(String username) {
        Connection connection = ConnectionToDB.getDBConnection();
        String result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ROLE);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("user_role");
                rs.close();
            } else {
                throw new MailUserNotExistException(username);
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }
        return result;
    }

    @Override
    public void setStatus(String currentUser, boolean status) {
        Connection connection = ConnectionToDB.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SET_STATUS);
            if (status) {
                ps.setString(1, APPICALL);
            } else {
                ps.setString(1, USER);
            }
            ps.setString(2, currentUser);
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }

    }

    @Override
    public Optional<MailUser> findByUsername(String username) {
        Connection connection = ConnectionToDB.getDBConnection();
        MailUser mailUser;
        try {
            PreparedStatement ps = connection.prepareStatement(GET_USER_BY_USERNAME);
            ps.setString(1, username);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                mailUser = extractUser(result);
                result.close();
            } else {
                throw new MailUserNotExistException(username);
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new QueryNotExecuteException();
        }
        return Optional.of(mailUser);
    }


    @Override
    public List<MailUser> getAllUsers() {
        List<MailUser> userList = new ArrayList<>();
        Connection connection = ConnectionToDB.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_USERS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userList.add((extractUser(rs)));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return userList;
    }

    private MailUser extractUser(ResultSet rs) throws SQLException {
        MailUser mailUser = new MailUser();
        mailUser.setId(rs.getInt("user_id"));
        mailUser.setUsername(rs.getString("user_name"));
        mailUser.setPassword(rs.getString("user_password"));
        mailUser.setRole(rs.getString("user_role"));
        return mailUser;
    }

}
