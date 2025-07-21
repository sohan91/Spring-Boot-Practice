package com.basic.Basic.repository;

import com.basic.Basic.dao.AccountDAO;
import org.springframework.stereotype.Repository;

@Repository
public class AccountImplementation implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+": Adding Account by Basic Advice..");



    }
}
