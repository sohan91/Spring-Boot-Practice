package com.dev.demoOnSrping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController{
       Coach coach;

       @Autowired
       CoachRestController(Coach myCoach)
       {
           coach = myCoach;
       }
   @GetMapping("/workout")
    public String getDetails()
   {
       return coach.dailyWorkOut();
   }
}
