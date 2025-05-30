package com.dev.demoOnSrping.beanConfig;

import com.dev.demoOnSrping.Coach;
import com.dev.demoOnSrping.SwimmingCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swim")
    public Coach swim()
    {
       return new SwimmingCoach();
    }
}
