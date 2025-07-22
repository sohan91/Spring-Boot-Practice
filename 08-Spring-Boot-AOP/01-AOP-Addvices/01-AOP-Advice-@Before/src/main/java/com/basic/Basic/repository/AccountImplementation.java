package com.basic.Basic.repository;

import com.basic.Basic.dao.AccountDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AccountImplementation implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+": Adding Account on BankAccount...");

    }
}
