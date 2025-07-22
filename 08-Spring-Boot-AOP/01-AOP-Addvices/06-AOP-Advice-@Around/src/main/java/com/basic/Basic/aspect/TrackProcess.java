package com.basic.Basic.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackProcess {

    @Around("execution(* com.basic.Basic.dao.AccountImplementation.*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable
    {
        Object object = null;
        try {
            System.out.println("------Initiating the process-----");
            System.out.println("Class-Name under execution: " + point.getSignature() + ", method-Name: " + point.getSignature().getName());
             object = point.proceed();
            System.out.println("-------Terminate the process------");
        }catch (Exception e)
        {
            System.out.println("Exception: "+e.getMessage().getClass().getName());
        }
        return object;
    }
}
