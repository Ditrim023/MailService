package com.example.mail.utils;

import java.util.Date;

public class DateCreator {
    private static java.sql.Date getCurrentDate() {
        Date today = new Date();
        return new java.sql.Date(today.getTime());
    }
}
