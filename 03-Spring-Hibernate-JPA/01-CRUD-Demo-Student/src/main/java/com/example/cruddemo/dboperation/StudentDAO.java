package com.example.cruddemo.dboperation;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student getDetails(Integer id);
    List<Student> getAllStudentDetails();
    List<Student> getOrderByStudentName();
    List<Student> findByFirstName(String name);
    void update(Student student);
    void delete(int id);
    int deleteAll();
}
