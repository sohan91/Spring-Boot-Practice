package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.exception.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("/api")
public class RestControllerDemo {

    private List<Student> students;
    @PostConstruct
    public void insert()
    {
        students = new ArrayList<>();
        students.add(new Student(101,"Sohan","Adisharlapalli"));
        students.add(new Student(102,"Arjun","Biradar"));
        students.add(new Student(103,"Venkatesh","Bolla"));
        students.add(new Student(104,"Saroj","Cheparolu"));
    }
    @GetMapping("/students")
    public List<Student> studentList()
    {
        return students;
    }
    @GetMapping("students/{studentId}")
    public Student listOfStudents(@PathVariable int studentId)
    {
        if(studentId > students.size() || studentId < 0)
        {
           throw new StudentNotFoundException("Student not Found: "+studentId);
        }
        return students.get(studentId);
    }




}
