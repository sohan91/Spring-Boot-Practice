package com.dev.demoOnSrping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class SwimmingCoach implements Coach{



    @Override
    public String dailyWorkOut() {
        return "Daily swim for 100 meters";
    }
}
