package com.example.mail.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

/**
 * @author Sergii Manko
 */
public final class Util {
  private Util() {
    throw new IllegalStateException("Utility class");
  }

  public static String getAuthorizedUserName() {
    final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return user.getUsername();
  }

  private static java.sql.Date getCurrentDate() {
    Date today = new Date();
    return new java.sql.Date(today.getTime());
  }
}
