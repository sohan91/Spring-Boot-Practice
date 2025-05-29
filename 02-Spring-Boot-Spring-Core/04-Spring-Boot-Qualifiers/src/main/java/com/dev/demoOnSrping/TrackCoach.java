package com.dev.demoOnSrping;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public String dailyWorkOut()
    {
        return "Practising Running for 20min 5km on track- "+getClass().getSimpleName();
    }
}
