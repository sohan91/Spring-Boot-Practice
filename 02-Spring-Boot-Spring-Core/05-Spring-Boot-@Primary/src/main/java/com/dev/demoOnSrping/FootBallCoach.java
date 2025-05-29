package com.dev.demoOnSrping;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootBallCoach implements Coach{
    public String dailyWorkOut()
    {
        return "Practising 1hr for Every Day- "+getClass().getSimpleName();
    }
}
