package com.thyemelefsecurity.Thymeleaf_Security.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

//    @Bean
//    public InMemoryUserDetailsManager detailsManager()
//    {
//        UserDetails sohan = User.builder().username("sohan")
//                .password("{noop}test123").roles("EMPLOYEE").build();
//        UserDetails raju = User.builder().username("raju")
//                .password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
//        UserDetails vikas = User.builder().username("vikas")
//                .password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();
//        return new InMemoryUserDetailsManager(sohan,raju,vikas);
//    }
    @Bean
    public JdbcUserDetailsManager detailsManager(DataSource dataSource)
    {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery("select user,pwd,activate from member where user=?");
        manager.setAuthoritiesByUsernameQuery("select user,role from roles where user=?");
        return manager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
    {
        security.authorizeHttpRequests(configure->
                        configure.requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leader/**").hasRole("MANAGER")
                                .requestMatchers("/system/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form->form.loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateUser")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                ).exceptionHandling(configure->configure.accessDeniedPage("/access-denied"))
                        .logout(LogoutConfigurer::permitAll);
        return security.build();
    }
}
