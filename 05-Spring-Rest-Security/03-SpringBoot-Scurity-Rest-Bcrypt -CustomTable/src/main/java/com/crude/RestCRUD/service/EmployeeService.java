package com.crude.RestCRUD.service;

import com.crude.RestCRUD.entity.Employee;
import org.springframework.context.annotation.Configuration;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
