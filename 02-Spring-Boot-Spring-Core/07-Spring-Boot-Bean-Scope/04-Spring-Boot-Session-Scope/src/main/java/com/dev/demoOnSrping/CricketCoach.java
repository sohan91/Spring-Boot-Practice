package com.dev.demoOnSrping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CricketCoach implements Coach {
    private final FootBallCoach footBallCoach1;
    private final FootBallCoach footBallCoach2;
    int numberOfSession = 0;
    @Autowired
    public CricketCoach(FootBallCoach coach1, FootBallCoach coach2) {
        this.footBallCoach1 = coach1;
        this.footBallCoach2 = coach2;
        System.out.println("Creating CricketCoach instance for request");
    }
    public int getNumberOfSession()
    {
        return numberOfSession++;
    }
    @Override
    public String dailyWorkOut() {
        return "Daily workout of half-an-hour - " + getClass().getSimpleName() +
                "\nFootBallCoach instances same? " + (footBallCoach1 == footBallCoach2);
    }
}