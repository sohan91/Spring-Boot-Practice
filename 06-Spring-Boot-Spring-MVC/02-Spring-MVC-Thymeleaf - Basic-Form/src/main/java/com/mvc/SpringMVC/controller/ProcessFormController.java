package com.mvc.SpringMVC.controller;

import com.mvc.SpringMVC.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProcessFormController {

    @GetMapping("/form")
    public String getForm(Model model)
    {
        Student theStudent = new Student();
        model.addAttribute("theStudent",theStudent);
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("student") Student theStudent)
    {
        System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());
        return "submit-form";
    }

}
