package com.dev.demoOnSrping;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component

public class TrackCoach implements Coach{
    private CricketCoach cricketCoach;

    @Autowired
    TrackCoach(CricketCoach coach)
    {
        this.cricketCoach = coach;
    }

    @PostConstruct
    public void initialise()
    {
        System.out.println("Init step after CricketCoach Bean is Created");
    }
    TrackCoach()
    {
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    public String dailyWorkOut()
    {
        return "Practising Running for 20min 5km on track- "+getClass().getSimpleName();
    }
    @PreDestroy
    public void destroy()
    {
        System.out.println("Bean is Destroyed...");
    }

}
