package com.example.mail.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLService {
    private static final String PASSWORD = "123456";
    private static final String CREATE_TABLES =
            "CREATE TABLE mail_user\n" +
                    "(\n" +
                    "    user_id       SERIAL PRIMARY KEY,\n" +
                    "    user_name     VARCHAR(255) UNIQUE NOT NULL,\n" +
                    "    user_role     VARCHAR(255) NOT NULL,\n" +
                    "    user_password VARCHAR(255) NOT NULL\n" +
                    ");\n" +
                    "CREATE TABLE mail\n" +
                    "(\n" +
                    "    mail_id  SERIAL PRIMARY KEY,\n" +
                    "    owner   VARCHAR(255) NOT NULL,\n" +
                    "    receiver   VARCHAR(255) NOT NULL,\n" +
                    "    author VARCHAR(255) NOT NULL,\n" +
                    "    mail_type VARCHAR(1200) NOT NULL,\n" +
                    "    theme    VARCHAR(255) NOT NULL,\n" +
                    "    date_create   TIMESTAMP,\n" +
                    "    text     text         NOT NULL\n" +
                    ");";
    private static final String INSERT_MAILS =
                    "insert into mail (owner,receiver, author,mail_type , theme, date_create,text) values ('Ivan.Petrov','Ivan.Petrov', 'Ivan.Sidorov', 'OOUGOING','testSendIN','2020-01-14 09:33:00','testtest');\n" +
                    "insert into mail (owner,receiver, author,mail_type, theme, date_create,text) values ('Ivan.Sidorov','Ivan.Sidorov', 'Ivan.Petrov', 'INCOMIG','testSendIN','2020-01-14 09:33:00','outout');\n" +
                    "insert into mail (owner,receiver, author,mail_type ,theme, date_create,text) values ('Ivan.Sidorov','Ivan.Sidorov', 'admin.antonov','OOUGOING','testSendIN','2020-07-15 15:41:00','testWithtime');\n" +
                    "insert into mail (owner,receiver, author, mail_type,theme, date_create,text) values ('admin.antonov','admin.antonov', 'Ivan.Sidorov', 'INCOMIG','testSendIN','2020-07-15 15:41:00','outout');\n" +
                    "insert into mail (owner,receiver, author, mail_type,theme, date_create,text) values ('Ivan.Petrov','Ivan.Petrov', 'admin.antonov', 'INCOMIG','testSendIN','2020-01-23 09:30:00','testWithtime');\n" +
                    "insert into mail (owner,receiver, author, mail_type,theme, date_create,text) values ('admin.antonov','admin.antonov', 'Ivan.Petrov','OOUGOING' ,'testSendIN','2020-01-23 09:30:00','testWithtime');";

    private static final String INSERT_USERS =
            "insert into mail_user (USER_NAME,USER_ROLE, USER_PASSWORD)\n" +
                    "values (?,'ROLE_USER', ?);";

    public void createTables() throws SQLException {
        Connection connection = ConnectionToDB.getDBConnection();
        Statement st = connection.createStatement();
        st.execute(CREATE_TABLES);
        st.close();
        connection.close();
    }

    public void fillMailTable() throws SQLException {
        Connection connection = ConnectionToDB.getDBConnection();
        Statement st = connection.createStatement();
        st.execute(INSERT_MAILS);
        st.close();
        connection.close();
    }

    public void fillTableUsers() throws SQLException {
        Connection connection = ConnectionToDB.getDBConnection();
        Statement st = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(INSERT_USERS);
        ps.setString(1, "admin.antonov");
        ps.setString(2, new BCryptPasswordEncoder(10).encode(PASSWORD));
        ps.executeUpdate();
        ps.setString(1, "Ivan.Sidoriv");
        ps.setString(2, new BCryptPasswordEncoder(10).encode(PASSWORD));
        ps.execute();
        ps.setString(1, "sidr.ivanov");
        ps.setString(2, new BCryptPasswordEncoder(10).encode(PASSWORD));
        ps.execute();
        ps.close();
        st.close();
        connection.close();
    }
}
