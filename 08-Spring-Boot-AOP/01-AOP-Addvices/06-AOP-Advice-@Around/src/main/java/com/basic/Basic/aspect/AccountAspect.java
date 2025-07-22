package com.basic.Basic.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AccountAspect {

    @Pointcut("execution(* com.basic.Basic.dao.*.*(..))")
    public void forDao(){}

    @Pointcut("execution(* com.basic.Basic.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("execution(* com.basic.Basic.dao.*.get*(..))")
    public void getter(){}

//    @Before("forDao() && (getter() || setter())")
//    public void checkForSetterGetter()
//    {
//        System.out.println(getClass().getName()+" for combining");
//    }

//
//    @Before("forDao()")
//    public void basicConfig()
//    {
//        System.out.println("\n----> Executing @Before on addAccount() ");
//    }
}
