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

    public String getScope()
    {
        return coach1.getClass().getSimpleName()+(coach1 == coach2 ?" is a SingleTon Scope ":" not is a SingleTon Scope ")+
        ("<br> coach1 HasCode is: "+coach1.hashCode()+" ,coach1 HashCode is: "+coach2.hashCode());
    }
}


