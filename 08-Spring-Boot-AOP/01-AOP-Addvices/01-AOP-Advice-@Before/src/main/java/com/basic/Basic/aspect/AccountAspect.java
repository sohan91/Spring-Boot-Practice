package com.basic.Basic.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AccountAspect {

    @Before("execution(public void addAccount()")
    public void basicConfig()
    {
        System.out.println("\n----> Executing @Before on addAccount() ");
    }
}
