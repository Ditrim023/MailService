package com.example.mail.service.impl;

import com.example.mail.entity.MailUser;
import com.example.mail.exeption.MailUserNotExistException;
import com.example.mail.exeption.QueryNotExecuteException;
import com.example.mail.security.MailUserService;
import com.example.mail.service.ConnectionToDB;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MailUserServiceImpl implements MailUserService {
    private static final String GET_USER_BY_USERNAME = "Select * from mail_user where user_name = ?";
    private static final String GET_ALL_USERS = "Select * from mail_user;";

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
                throw new MailUserNotExistException();
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
