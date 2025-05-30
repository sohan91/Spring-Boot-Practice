package com.dev.demoOnSrping.Controller;

import com.dev.demoOnSrping.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
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


    @GetMapping("/check")
    public String getScope()
    {
        return "Cricket Coach class "+(coach1 == coach2 ?" is a Request Scope ":" not is a Request Scope ")+
        ("<br><br> <strong>coach1 HasCode</strong> is: <strong>"+coach1.hashCode()+"</strong> ,<strong>coach2 HashCode</strong> is: <strong>"+coach2.hashCode()+"</strong>");
    }
}


