package com.dev.demoOnSrping;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements  Coach{

    CricketCoach()
    {
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    public String dailyWorkOut()
    {
        return "daily work out of half-an-hour - "+ getClass().getSimpleName();
    }
}
