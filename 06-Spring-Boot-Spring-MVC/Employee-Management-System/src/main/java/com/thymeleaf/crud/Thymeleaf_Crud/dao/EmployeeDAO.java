package com.thymeleaf.crud.Thymeleaf_Crud.dao;

import com.thymeleaf.crud.Thymeleaf_Crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    void update(Employee employee);
    void deleteById(int id);
    List<Employee> orderByAsc();
}
