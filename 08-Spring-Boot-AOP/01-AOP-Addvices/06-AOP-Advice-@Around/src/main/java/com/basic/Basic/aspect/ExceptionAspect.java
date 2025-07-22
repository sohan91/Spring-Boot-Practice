package com.basic.Basic.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {


    @Pointcut("execution(* com.basic.Basic..*.*(..))")
    public void exception(){};
    @AfterThrowing(
            pointcut = "exception()",
            throwing = "theException"
    )
    public void handleException(JoinPoint joinPoint,Throwable theException)
    {
        System.out.println("@AfterThrowing advice Exception---"+theException);
    }
}
