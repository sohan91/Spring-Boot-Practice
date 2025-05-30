package com.dev.demoOnSrping;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component

public class TrackCoach implements Coach{
    TrackCoach()
    {
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    public String dailyWorkOut()
    {
        return "Practising Running for 20min 5km on track- "+getClass().getSimpleName();
    }
}
