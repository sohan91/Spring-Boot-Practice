package com.crude.RestCRUD.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class UserSecurityConfig {
//
//    @Bean
//    public InMemoryUserDetailsManager manager()
//    {
//        UserDetails sohan = User.builder().username("sohan")
//                .password("{noop}sohan@202020").roles("EMPLOYEE").build();
//
//        UserDetails mani = User.builder().username("mani")
//                .password("{noop}mani@2222").roles("EMPLOYEE","MANAGER").build();
//
//        UserDetails latha = User.builder().username("latha")
//                .password("{noop}latha@303030").roles("EMPLOYEE","MANAGER","ADMIN").build();
//
//        return new InMemoryUserDetailsManager(sohan,mani,latha);
//    }
//
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        security.authorizeHttpRequests(configure->
                configure
                        .requestMatchers(HttpMethod.GET,"api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH,"api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN"));
           security.httpBasic(Customizer.withDefaults());
           security.csrf(crsf ->crsf.disable());

           return security.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        return new JdbcUserDetailsManager(dataSource);
    }
}
