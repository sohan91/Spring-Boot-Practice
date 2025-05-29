package com.outsidescope;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public String dailyworkout()
    {
        return "daily work out of half-an-hour";
    }
}
