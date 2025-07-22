package com.basic.Basic.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ManagementImplementation implements ManagementDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass().getName()+": Adding Account for Management..");

    }
}
