package com.example.mail.security;

import com.example.mail.entity.MailUser;

import java.util.List;
import java.util.Optional;


public interface MailUserService {
    Optional<MailUser> findByUsername(String username);

    List<MailUser> getAllUsers();
}
