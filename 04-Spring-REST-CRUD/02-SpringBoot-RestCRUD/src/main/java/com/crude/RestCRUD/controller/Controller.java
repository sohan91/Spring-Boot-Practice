package com.crude.RestCRUD.controller;

import com.crude.RestCRUD.dao.DAOImplementaion;
import com.crude.RestCRUD.dao.DAOInterface;
import com.crude.RestCRUD.entity.Employee;
import com.crude.RestCRUD.exception.CustomException;
import com.crude.RestCRUD.service.EmployeeService;
import jakarta.el.ELManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    EmployeeService service;

    @Autowired
  Controller(EmployeeService theservice)
  {
      service = theservice;
  }

    @GetMapping("/employees")
    public List<Employee> employees()
    {
           List<Employee> employees = service.findAll();
           return employees;
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable int empId)
    {

       Employee employee =  service.findById(empId);
       if(employee == null)
       {
           throw new CustomException("Data Not Found on ID : "+empId);
       }
       return employee;
    }

}
