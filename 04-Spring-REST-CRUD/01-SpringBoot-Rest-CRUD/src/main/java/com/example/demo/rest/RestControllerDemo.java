package com.example.demo.rest;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllerDemo {
    @GetMapping("/student")
    public List<Student> listOfStudents()
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101,"Sohan","Adisharlapalli"));
        students.add(new Student(102,"Arjun","Biradar"));
        students.add(new Student(103,"Venkatesh","Bolla"));
        students.add(new Student(104,"Saroj","Cheparolu"));

        return students;
    }
}
