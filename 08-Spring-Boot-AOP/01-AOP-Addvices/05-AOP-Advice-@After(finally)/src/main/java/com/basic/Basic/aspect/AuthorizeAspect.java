package com.basic.Basic.aspect;

import com.basic.Basic.dao.AccountDAO;
import com.basic.Basic.dao.AccountImplementation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.awt.print.Paper;

@Component
@Order(3)
@Aspect
public class AuthorizeAspect {

    @Autowired
    private AccountDAO dao;

    @AfterReturning("com.basic.Basic.aspect.AccountAspect.setter()")
    public void isAuthorize()
    {

            System.out.println(" Authorized");


    }
}
