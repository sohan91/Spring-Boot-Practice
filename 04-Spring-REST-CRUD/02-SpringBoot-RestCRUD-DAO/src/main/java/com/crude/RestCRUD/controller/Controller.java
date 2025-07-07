package com.crude.RestCRUD.controller;

import com.crude.RestCRUD.entity.Employee;
import com.crude.RestCRUD.exception.CustomException;
import com.crude.RestCRUD.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    private ObjectMapper objectMapper;
    EmployeeService service;


    @Autowired
    public Controller(ObjectMapper theObjectMapper,EmployeeService employeeService)
    {
        objectMapper = theObjectMapper;
        service = employeeService;
    }


    Controller(EmployeeService theService)
    {
      service = theService;
    }

    @GetMapping("/employees")
    private List<Employee> employees()
    {
           return service.findAll();
    }

    @GetMapping("/employee/{empId}")
    private Employee getEmployee(@PathVariable int empId)
    {

       Employee employee =  service.findById(empId);
       if(employee == null)
       {
           throw new CustomException("Data Not Found on ID : "+empId);
       }
       return employee;
    }
    @PostMapping("/employee")
    private Employee addEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        return service.save(employee);
    }

    @PutMapping("/employees")
    private Employee updateEmployee(@RequestBody Employee employee)
    {
        return service.save(employee);

    }

    @PatchMapping("/employees/{empId}")
    private Employee patchEmployee(@PathVariable int empId, @RequestBody Map<String,Object> map)
    {
        Employee employee = service.findById(empId);
        if(employee == null)
        {
            throw  new RuntimeException("Employee Details not Found for ID "+empId);
        }
        if(map.containsKey("id"))
        {
            throw new RuntimeException("Not Allowed to change Employee ID");
        }

        Employee updatedEmployee = patchPayLoad(employee,map);
        return  service.save(updatedEmployee);

    }

    private Employee patchPayLoad(Employee employee,Map<String,Object> map)
    {
        ObjectNode employeeNode = objectMapper.convertValue(employee,ObjectNode.class);

        ObjectNode mapObjectNode = objectMapper.convertValue(map,ObjectNode.class);

        employeeNode.setAll(mapObjectNode);

        return objectMapper.convertValue(employeeNode,Employee.class);
    }

    @DeleteMapping("/employee/{empId}")
    private String deleteEmployee(@PathVariable int empId)
    {
        Employee employee = service.findById(empId);
        if(employee == null)
        {
            throw  new RuntimeException("Employee Details not Found for ID "+empId);
        }

        service.deleteById(empId);
        return "Deleted Employee ID - "+empId;
    }

}
