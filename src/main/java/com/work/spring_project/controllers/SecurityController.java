package com.work.spring_project.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityController extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user")
                .password("pass")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("pass")
                .roles("ADMIN")
                .and()
                .withUser("manager")
                .password("pass")
                .roles("MANAGER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/manager_registration").hasRole("ADMIN")
                .antMatchers("/orders").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/order").hasAnyRole("ADMIN", "MANAGER", "USER")
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }



    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
