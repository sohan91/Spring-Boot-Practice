package com.thyemelefsecurity.Thymeleaf_Security.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager detailsManager()
    {
        UserDetails sohan = User.builder().username("sohan")
                .password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails raju = User.builder().username("raju")
                .password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
        UserDetails vikas = User.builder().username("vikas")
                .password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(sohan,raju,vikas);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
    {
        security.authorizeHttpRequests(configure->configure.anyRequest().authenticated()
                )
                .formLogin(form->form.loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateUser")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                        .logout(LogoutConfigurer::permitAll);
        return security.build();
    }
}
