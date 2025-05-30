package com.dev.demoOnSrping.Controller;

import com.dev.demoOnSrping.Coach;
import com.dev.demoOnSrping.CricketCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController{
      CricketCoach coach1;
       Coach coach2;

       @Autowired
       CoachRestController(CricketCoach coach,
                           @Qualifier("cricketCoach") Coach anotherCoach)
       {

           coach1 = coach;
           coach2 = anotherCoach;
       }


    @GetMapping("/check")
    public int getSession()
    {
        return coach1.getNumberOfSession();
    }
}


