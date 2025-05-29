package com.dev.demoOnSrping.rest;

import com.dev.demoOnSrping.Coach;
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
       CoachRestController(@Qualifier("cricketCoach") Coach myCoach)
       {

           coach = myCoach;
           System.out.println("In Constructor: "+getClass().getSimpleName());
       }

   @GetMapping("/workout")
    public String getDetails()
   {
       return coach.dailyWorkOut();
   }
}
