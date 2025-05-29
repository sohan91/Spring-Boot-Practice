package com.dev.demoOnSrping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController{
       Coach myCoach;

       @Autowired
    public void myCoach(Coach coach)
       {
           myCoach = coach;
       }


       @GetMapping("/workout")
      public String getdetails()
       {
           return myCoach.dailyworkout();
       }
}
