package com.dev.demoOnSrping;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
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
