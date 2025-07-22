package com.basic.Basic.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AccountImplementation implements AccountDAO {

    String fName;
    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+": Adding Account on BankAccount...");

    }

    @Override
    public void setName(String name) {
        this.fName = name;
    }

    @Override
    public String getName() {
        return this.fName;
    }

}
