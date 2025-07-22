package com.basic.Basic.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class AccountImplementation implements AccountDAO {

    String fName;
    List<String> names;
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

    @Override
    public void  accountHolders(List<String> names) {
       this.names = names;
    }

    @Override
    public List<String> returnHolders() {
        return this.names;
    }

}
