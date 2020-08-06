package com.example.mail.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProfileConfig extends WebSecurityConfigurerAdapter {

    private UserService userDetailsService;

    public ProfileConfig(UserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void registerAuthenticationManager(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/mails", "/users", "/mail/**", "/settings", "/check/api", "/api/set").hasAnyRole("USER", "APICALL")
                .antMatchers("/api/**").hasRole("APICALL").and().httpBasic()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().formLogin().loginPage("/login").failureUrl("/403").permitAll()
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/mails")
                .and().logout()
                .logoutSuccessUrl("/login");
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/css/**", "/images/**");
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
