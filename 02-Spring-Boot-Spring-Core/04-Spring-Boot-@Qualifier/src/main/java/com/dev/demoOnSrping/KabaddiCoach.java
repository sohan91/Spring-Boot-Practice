package com.dev.demoOnSrping;

import org.springframework.stereotype.Component;

@Component
public class KabaddiCoach implements Coach{

    public String dailyWorkOut()
    {
        return "Practise 15min in Raiding and 20min in Defence";
    }
}
