package com.thymeleaf.crud.Thymeleaf_Crud.service;

import com.thymeleaf.crud.Thymeleaf_Crud.dao.EmployeeDAO;
import com.thymeleaf.crud.Thymeleaf_Crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeDAO{
    private EmployeeDAO employeeDAO;

    EmployeeService(EmployeeDAO dao)
    {
       employeeDAO = dao;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override

    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public List<Employee> orderByAsc() {
        return employeeDAO.orderByAsc();
    }
}
