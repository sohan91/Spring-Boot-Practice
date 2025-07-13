package com.thymeleaf.crud.Thymeleaf_Crud.dao;

import com.thymeleaf.crud.Thymeleaf_Crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

    private EntityManager manager;

    public EmployeeDAOImplementation(EntityManager theManager)
    {
        manager = theManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
       manager.merge(employee);
    }

    @Override
    public Employee findById(int id) {
        return manager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> list = manager.createQuery("FROM Employee",Employee.class);
        return list.getResultList();
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        manager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Employee employee = manager.find(Employee.class,id);
        manager.remove(employee);
    }

    @Override
    public List<Employee> orderByAsc() {
       TypedQuery<Employee> employeeTypedQuery = manager.createQuery( "SELECT e FROM Employee e ORDER BY e.firstName ASC",Employee.class);
       return employeeTypedQuery.getResultList();
    }
}
