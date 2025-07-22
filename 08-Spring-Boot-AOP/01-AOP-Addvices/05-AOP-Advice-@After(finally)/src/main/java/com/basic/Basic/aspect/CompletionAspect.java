package com.basic.Basic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CompletionAspect {

    @After("execution(* com.basic.Basic.*.*.*(..))")
    public void complete(JoinPoint joinPoint)
    {
        System.out.println("(After)-Completed Execution: "+joinPoint.getSignature());
    }
}
