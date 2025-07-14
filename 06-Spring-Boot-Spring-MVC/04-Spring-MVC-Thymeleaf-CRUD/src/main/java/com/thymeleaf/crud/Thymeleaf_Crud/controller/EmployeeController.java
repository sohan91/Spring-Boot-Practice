package com.thymeleaf.crud.Thymeleaf_Crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.thymeleaf.crud.Thymeleaf_Crud.entity.Employee;
import com.thymeleaf.crud.Thymeleaf_Crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    private ObjectMapper mapper;

    public EmployeeController(EmployeeService theService,ObjectMapper theMapper)

    {
        service = theService;
        mapper = theMapper;
    }
    @GetMapping("/list")
    public String list(Model model)
    {
        List<Employee> employees ;
        employees = service.findAll();
        employees = service.orderByAsc();
        model.addAttribute("theEmployee",employees);
        return "list-employees";
    }


    @GetMapping("/formForAdd")
    public String form(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("addEmployee",employee);
        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("addEmployee")Employee theEmployee)
    {
        service.save(theEmployee);
        return "redirect:list";
    }

    @GetMapping("/updateEmployee")
    public String update(@RequestParam("employeeId")int id,Model model)
    {
        Employee employee = service.findById(id);
        model.addAttribute("addEmployee",employee);
        return "add-employee";
    }

    @GetMapping("/deleteEmployee")
    public String delete(@RequestParam("employeeId")int id,Model model)
    {
        service.deleteById(id);
        model.addAttribute("addEmployee");
        return "redirect:list";
    }


}
