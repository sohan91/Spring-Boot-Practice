package com.manytomany.manytomany.dao;


import com.manytomany.manytomany.entity.Course;
import com.manytomany.manytomany.entity.Student;

public interface StudentCourseDAO {
    void save(Course course);
    Course findCourseDetailsById(int id);
    Student findStudentDetailsById(int id);
    void updateStudent(Student student);
    void deleteCourseById(int id);
    void deleteStudentById(int id);
}
