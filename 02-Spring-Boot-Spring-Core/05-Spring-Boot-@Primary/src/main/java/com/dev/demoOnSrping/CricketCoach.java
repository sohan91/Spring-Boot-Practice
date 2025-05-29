package com.dev.demoOnSrping;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements  Coach{

    public String dailyWorkOut()
    {
        return "daily work out of half-an-hour - "+ getClass().getSimpleName();
    }
}
