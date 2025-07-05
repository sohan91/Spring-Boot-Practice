package com.crude.RestCRUD.dao;

import com.crude.RestCRUD.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOImplementaion implements  DAOInterface{
    private EntityManager manager;

    @Autowired
    DAOImplementaion(EntityManager theManager)
    {
        manager = theManager;
    }

    public List<Employee> findAll()
    {
        TypedQuery<Employee> employeeTypedQuery = manager.createQuery("FROM Employee",Employee.class);
        List<Employee> employees = employeeTypedQuery.getResultList();
        return employees;
    }

    @Override
    public Employee save(Employee employee) {
        Employee saveEmployee = manager.merge(employee);
        return employee;
    }

    @Transactional
    @Override
    public Employee findById(int id) {
        Employee employee = manager.find(Employee.class,id);
        return employee;
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Employee employee = manager.find(Employee.class,id);
        manager.remove(employee);
    }

}
