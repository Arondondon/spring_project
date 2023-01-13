package com.work.spring_project.configs;

import com.work.spring_project.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    /*
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

     */


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/manager_registration").hasRole("ADMIN")
                .antMatchers("/orders", "/car_park/add_car", "/catalog/add_service").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/order").hasAnyRole("ADMIN", "MANAGER", "USER")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
