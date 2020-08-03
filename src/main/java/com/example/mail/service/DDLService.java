package com.example.mail.service;

import com.example.mail.dao.ConnectionToDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLService {
    private static final String CREATE_TABLES =
            "CREATE TABLE mail_user\n" +
                    "(\n" +
                    "    user_id       SERIAL PRIMARY KEY,\n" +
                    "    user_name     VARCHAR(255) NOT NULL,\n" +
                    "    user_password VARCHAR(255) NOT NULL\n" +
                    ");\n" +
                    "CREATE TABLE mail\n" +
                    "(\n" +
                    "    mail_id  SERIAL PRIMARY KEY,\n" +
                    "    to_who   VARCHAR(255) NOT NULL,\n" +
                    "    from_who VARCHAR(255) NOT NULL,\n" +
                    "    theme    VARCHAR(255) NOT NULL,\n" +
                    "    date_create   TIMESTAMP,\n" +
                    "    text     text         NOT NULL\n" +
                    ");";
    private static final String INSERT_MAILS =
            "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-11-23 01:30:00','testtest');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-01-14 09:33:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-04-21 12:35:00','txttext');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-07-23 21:36:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'admin.antonov', 'testSendIN','2020-09-15 15:41:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('admin.antonov', 'Ivan.Sidoriv', 'testSendIN','2020-10-23 17:30:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-11-23 01:30:00','testtest');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-01-14 09:33:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-04-21 12:35:00','txttext');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-07-23 21:36:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'admin.antonov', 'testSendIN','2020-09-15 15:41:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('admin.antonov', 'Ivan.Sidoriv', 'testSendIN','2020-10-23 17:30:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-11-23 01:30:00','testtest');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-01-14 09:33:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-04-21 12:35:00','txttext');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-07-23 21:36:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'admin.antonov', 'testSendIN','2020-09-15 15:41:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('admin.antonov', 'Ivan.Sidoriv', 'testSendIN','2020-10-23 17:30:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-11-23 01:30:00','testtest');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-01-14 09:33:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-04-21 12:35:00','txttext');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-07-23 21:36:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'admin.antonov', 'testSendIN','2020-09-15 15:41:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('admin.antonov', 'Ivan.Sidoriv', 'testSendIN','2020-10-23 17:30:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-11-23 01:30:00','testtest');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-01-14 09:33:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('sidr.ivanov', 'Ivan.Sidoriv', 'testSendIN','2020-04-21 12:35:00','txttext');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'sidr.ivanov', 'testSendIN','2020-07-23 21:36:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('Ivan.Sidoriv', 'admin.antonov', 'testSendIN','2020-09-15 15:41:00','outout');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('admin.antonov', 'Ivan.Sidoriv', 'testSendIN','2020-10-23 17:30:00','testWithtime');\n" +
                    "insert into mail (to_who, from_who, theme, date_create,text) values ('admin.antonov', 'Ivan.Sidoriv', 'testSendIN','2020-11-23 09:30:00','testWithtime');";

    private static final String INSERT_USERS = "insert into mail_user (USER_NAME, USER_PASSWORD)\n" +
            "values ('sidr.ivanov', '123456');\n" +
            "insert into mail_user (USER_NAME, USER_PASSWORD)\n" +
            "values ('Ivan.Sidoriv', '123456');\n" +
            "insert into mail_user (USER_NAME, USER_PASSWORD)\n" +
            "values ('admin.antonov', '123456');";

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
        st.execute(INSERT_USERS);
        st.close();
        connection.close();
    }
}
