package com.dev.demoOnSrping;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class KabaddiCoach implements Coach{
    KabaddiCoach()
    {
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    public String dailyWorkOut()
    {
        return "Practise 15min in Raiding and 20min in Defence";
    }
}
