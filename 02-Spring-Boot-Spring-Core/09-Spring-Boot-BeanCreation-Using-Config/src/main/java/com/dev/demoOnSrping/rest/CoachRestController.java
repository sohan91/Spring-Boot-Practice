package com.dev.demoOnSrping.rest;

import com.dev.demoOnSrping.Coach;
import com.dev.demoOnSrping.SwimmingCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController{

  Coach coach;
    @Autowired
    CoachRestController(@Qualifier("swim") Coach swimCoach)
    {
        coach = swimCoach;
        System.out.println("Bean has been created for the Swimming class...");
    }

    @GetMapping("/check")
    public String getDetails()
   {
       return coach.dailyWorkOut();
   }



}
