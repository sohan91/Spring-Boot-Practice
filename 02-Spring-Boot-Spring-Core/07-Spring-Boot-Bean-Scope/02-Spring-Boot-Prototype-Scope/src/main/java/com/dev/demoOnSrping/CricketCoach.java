package com.dev.demoOnSrping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CricketCoach implements  Coach{
     FootBallCoach footBallCoach1;
     FootBallCoach footBallCoach2;

     @Autowired
     CricketCoach(FootBallCoach coach1,FootBallCoach coach2)
     {
         footBallCoach1 = coach1;
         footBallCoach2 = coach2;
     }

    CricketCoach()
    {
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    public String dailyWorkOut()
    {
        return "daily work out of half-an-hour - "+ getClass().getSimpleName();
    }
}
