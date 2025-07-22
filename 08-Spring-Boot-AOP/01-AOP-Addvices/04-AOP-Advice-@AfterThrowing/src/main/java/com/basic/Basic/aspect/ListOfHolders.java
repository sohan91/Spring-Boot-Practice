package com.basic.Basic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class ListOfHolders {

    @AfterReturning(
            value = "execution(* com.basic.Basic.dao.*.returnHolders(..))",
            returning = "result"
    )
    public void returnList(JoinPoint joinPoint, List<String> result) {
        System.out.println("@After Returning...");
        System.out.println("Method: " + joinPoint.getSignature());
        System.out.println("Returned list: " + result);
    }

}
