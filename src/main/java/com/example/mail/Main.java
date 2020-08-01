package com.example.mail;

import java.beans.XMLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
            menu.run();
    }
}
