package com.example.security.SecurityFlow.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
    {
        return security.csrf(csrf->csrf.disable())
               .authorizeHttpRequests(request->request.anyRequest().authenticated())
              .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager manager()
    {
        UserDetails user1 = User.builder().username("sohan").password("{noop}sohan@123").roles("EMPLOYEE").build();

        UserDetails user2 = User.builder().username("raju").password("{noop}raju@123").roles("MANAGER").build();

        UserDetails user3 = User.builder().username("vikas").password("{noop}vikas@123").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
}
