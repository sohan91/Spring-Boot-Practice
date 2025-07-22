package com.basic.Basic.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class AccountImplementation implements AccountDAO {

    String fName;
    List<String> names;
    int age;
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

    @Override
    public void setAge(int age) {
        try
        {
            this.age = age;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int getAge() {
        if(age == 0)
        {
            throw new RuntimeException();
        }
        return age;
    }

}
