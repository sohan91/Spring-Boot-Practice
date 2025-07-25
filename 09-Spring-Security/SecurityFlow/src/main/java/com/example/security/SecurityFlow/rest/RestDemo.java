package com.example.security.SecurityFlow.rest;

import com.example.security.SecurityFlow.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestDemo {

    List<Student> students = new ArrayList<>(List.of (new Student(1,"sohan",23),
            new Student(2,"dony",33)));
    @GetMapping("/students")
    public List<Student> get(HttpServletRequest request)
    {
        return students;
    }
    @PostMapping("/students")
    public List<Student> setStd(@RequestBody Student student)
    {
         students.add(student);
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken getId(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
