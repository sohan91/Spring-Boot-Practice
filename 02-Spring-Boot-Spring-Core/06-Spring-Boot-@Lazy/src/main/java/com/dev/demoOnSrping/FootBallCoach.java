package com.dev.demoOnSrping;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootBallCoach implements Coach{
    FootBallCoach()
    {
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    public String dailyWorkOut()
    {
        return "Practising 1hr for Every Day- "+getClass().getSimpleName();
    }
}
