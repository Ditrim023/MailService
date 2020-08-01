package com.example.mail;

import com.example.mail.dao.MailDAO;
import com.example.mail.dao.impl.MailDAOImpl;
import com.example.mail.entity.Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MailDAO mailDAO = new MailDAOImpl();
        Class.forName ("org.h2.Driver");
        Connection conn = DriverManager.getConnection ("jdbc:h2:mem:testdb", "sa","");
        String sql1 = "CREATE TABLE mail\n" +
                "(\n" +
                "    mail_id  SERIAL PRIMARY KEY,\n" +
                "    to_who   VARCHAR(255) NOT NULL,\n" +
                "    from_who VARCHAR(255) NOT NULL,\n" +
                "    theme    VARCHAR(255) NOT NULL,\n" +
                "    text     text         NOT NULL\n" +
                ");";
        String sql = "insert into mail (to_who, from_who, theme, text) values ('ToTest@emaple','fromTest@examaple','test','dddddddddddddddvvsdvdsddddddddddddddddddddddddddddddddddddddddddddddddddd');\n";
        Statement st = conn.createStatement();
        st.execute(sql1);
        st.execute(sql);
        List<Mail> list = mailDAO.getAllMail();
        System.out.println(list);
    }
}
