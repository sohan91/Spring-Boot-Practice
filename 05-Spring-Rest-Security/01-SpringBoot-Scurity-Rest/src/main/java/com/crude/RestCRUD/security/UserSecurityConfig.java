package com.crude.RestCRUD.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager manager()
    {
        UserDetails sohan = User.builder().username("sohan")
                .password("{noop}sohan@202020").roles("Employee").build();

        UserDetails mani = User.builder().username("mani")
                .password("{noop}mani@2222").roles("Employee","Manager").build();

        UserDetails latha = User.builder().username("latha")
                .password("{noop}latha@303030").roles("Employee","Manager","Admin").build();

        return new InMemoryUserDetailsManager(sohan,mani,latha);
    }
}
