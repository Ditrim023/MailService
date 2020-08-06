package com.example.mail.security;

import com.example.mail.entity.MailUser;
import com.example.mail.service.MailUserService;
import com.example.mail.service.impl.MailUserServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private MailUserService mailUserService = new MailUserServiceImpl();

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<MailUser> mailUser = mailUserService.findByUsername(username);
        if (mailUser.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " does not exist");
        }
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(mailUser.get().getRole()));
        return new org.springframework.security.core.userdetails.User(mailUser.get().getUsername(), mailUser.get().getPassword(), roles);
    }
}
