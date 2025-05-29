package com.dev.demoOnSpring.restcontroller;

import com.outsidescope.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController{
       Coach myCoach;

       @Autowired
      public CoachRestController(Coach theCoach)
       {
           myCoach = theCoach;
       }

       @GetMapping("/workout")
      public String getdetails()
       {
           return myCoach.dailyworkout();
       }
}
