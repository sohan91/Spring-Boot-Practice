package com.basic.Basic.repository;

import com.basic.Basic.dao.AccountDAO;
import com.basic.Basic.dao.ManagementDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ManagementImplementation implements ManagementDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+": Adding Account for Management..");

    }
}
