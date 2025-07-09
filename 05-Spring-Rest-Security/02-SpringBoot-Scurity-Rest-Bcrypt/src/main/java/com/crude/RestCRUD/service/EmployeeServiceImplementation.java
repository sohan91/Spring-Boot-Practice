package com.crude.RestCRUD.service;

import com.crude.RestCRUD.dao.EmployeeJpaRepository;
import com.crude.RestCRUD.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    EmployeeJpaRepository repository;

    @Autowired
    EmployeeServiceImplementation(EmployeeJpaRepository theRepository)
    {
        repository = theRepository;
    }
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> getEmployee = repository.findById(id);
        Employee employee = null;
        if(getEmployee.isPresent())
        {
            employee =getEmployee.get();
        }
        else {
            throw new RuntimeException("Details not Found on ID : "+id);
        }
        return employee;
    }


    @Override
    public void deleteById(int id) {
        Employee emp = findById(id);
        repository.delete(emp);
    }
}
