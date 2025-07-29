package com.thymeleaf.crud.Thymeleaf_Crud.securityconfig;

import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class EmployeeSecurity {

 @Bean
 public JdbcUserDetailsManager detailsManager(DataSource dataSource)
 {
     JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
     manager.setUsersByUsernameQuery("select user,pwd,activate from member where user=?");
     manager.setAuthoritiesByUsernameQuery("select user,role from roles where user=?");
     return manager;
 }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                .authorizeHttpRequests(configure -> configure
                        .requestMatchers("/login", "/authenticateUser").permitAll()
                        .requestMatchers("/employees/list").hasRole("EMPLOYEE")
                        .requestMatchers("/employees/updateEmployee").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/employees/deleteEmployee").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/employees/login")
                        .loginProcessingUrl("/authenticateUser")
                        .defaultSuccessUrl("/employees/list", true)
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return security.build();
    }

}
