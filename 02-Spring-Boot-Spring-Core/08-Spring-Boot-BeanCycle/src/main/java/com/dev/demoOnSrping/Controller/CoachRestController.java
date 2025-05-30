package com.dev.demoOnSrping.Controller;

import com.dev.demoOnSrping.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController{
       Coach coach1;
       Coach coach2;
       @Autowired
       CoachRestController(@Qualifier("cricketCoach") Coach coach,
                           @Qualifier("cricketCoach") Coach anotherCoach)
       {

           coach1 = coach;
           coach2 = anotherCoach;
       }

   @GetMapping("/workout")
    public String getDetails()
   {
       return coach1.dailyWorkOut();
   }
    @GetMapping("/check")
    private String hasSameInstance()
    {
        return "Is coach1&coach2 has Same Instance: "+(coach1 == coach2);
    }
}


