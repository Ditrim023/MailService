package com.example.mail.service;

import com.example.mail.dao.ConnectionToDB;
import com.example.mail.dao.GeneralDAO;
import com.example.mail.utils.FileReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLService {
    private static final String FILE_PATH_CREATE = "sql/create_tables.sql";
    private static final String FILE_PATH_DROP = "sql/drop_tables.sql";
    private FileReader fileReader = new FileReader();
    private GeneralDAO ddlDao = new GeneralDAO();

    public void createTables() throws SQLException {
        Connection connection = ConnectionToDB.getDBConnection();
        String create =
                "CREATE TABLE Mail\n" +
                "(\n" +
                "    mail_id  SERIAL PRIMARY KEY,\n" +
                "    to_who   VARCHAR(255) NOT NULL,\n" +
                "    from_who VARCHAR(255) NOT NULL,\n" +
                "    theme    VARCHAR(255) NOT NULL,\n" +
                "    text     text         NOT NULL\n" +
                ");\n" +
                "\n" +
                "insert into mail (to_who, from_who, theme, text) values ('ToTest@emaple','fromTest@examaple','test','dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd');\n" +
                "insert into mail (to_who, from_who, theme, text) values ('ToTest@emaple','fromTest@examaple','test','dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd');\n";

        Statement st = connection.createStatement();
        st.execute(create);
    }

}
