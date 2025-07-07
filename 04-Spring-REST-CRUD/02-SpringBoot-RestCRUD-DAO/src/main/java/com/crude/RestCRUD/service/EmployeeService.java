package com.crude.RestCRUD.service;

import com.crude.RestCRUD.dao.DAOInterface;
import com.crude.RestCRUD.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements DAOInterface {

    DAOInterface daoInterface;

    @Autowired
    EmployeeService(DAOInterface daoInterface)
    {
        this.daoInterface = daoInterface;
    }
    @Override
    public List<Employee> findAll() {
        return daoInterface.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return daoInterface.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return daoInterface.findById(id);
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        daoInterface.deleteById(id);
    }
}
