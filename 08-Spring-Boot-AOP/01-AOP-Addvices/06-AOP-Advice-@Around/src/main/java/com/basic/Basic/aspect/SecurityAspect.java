package com.basic.Basic.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SecurityAspect {

    @Before("com.basic.Basic.aspect.AccountAspect.forDao()")
    public void provideSecurity()
    {
        System.out.println("Security check...");
    }
}
