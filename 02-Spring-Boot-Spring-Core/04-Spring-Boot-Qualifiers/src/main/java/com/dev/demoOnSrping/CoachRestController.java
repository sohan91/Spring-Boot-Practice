package com.dev.demoOnSrping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController{
       Coach football;
       Coach cricket;
       Coach track;

       @Autowired
    public void myCoach(@Qualifier("footBallCoach") Coach footBallCoach,
                        @Qualifier("cricketCoach") Coach cricketCoach,
                        @Qualifier("trackCoach")Coach trackCoach)
       {
           football = footBallCoach;
           cricket = cricketCoach;
           track= trackCoach;
       }


       @GetMapping("/footballworkout")
      public String getdetails()
       {
           return football.dailyWorkOut();
       }

       @GetMapping("/cricketworkout")
     public String getDetatils()
       {
           return cricket.dailyWorkOut();
       }
       @GetMapping("/trackworkout")
       public String getDetails()
       {
           return track.dailyWorkOut();
       }
}
