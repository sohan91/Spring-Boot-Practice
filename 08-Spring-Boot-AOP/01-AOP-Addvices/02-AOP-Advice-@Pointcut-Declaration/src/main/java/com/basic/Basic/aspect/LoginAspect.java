package com.basic.Basic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class LoginAspect {

    @Before("com.basic.Basic.aspect.AccountAspect.setter()")
    public void login()
    {
        System.out.println("check login...");
    }
}
