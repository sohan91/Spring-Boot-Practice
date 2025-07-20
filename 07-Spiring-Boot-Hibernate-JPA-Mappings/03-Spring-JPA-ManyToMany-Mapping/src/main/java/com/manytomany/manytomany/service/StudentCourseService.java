package com.manytomany.manytomany.service;

import com.manytomany.manytomany.dao.StudentCourseDAO;
import com.manytomany.manytomany.entity.Course;
import com.manytomany.manytomany.entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class StudentCourseService implements StudentCourseDAO{

    private StudentCourseDAO studentCourseDAO;

    public StudentCourseService(StudentCourseDAO studentCourseDAOs)
    {
        studentCourseDAO = studentCourseDAOs;
    }


    @Override
    @Transactional
    public void save(Course course) {
        studentCourseDAO.save(course);
    }

    @Override
    public Course findCourseDetailsById(int id) {
        return studentCourseDAO.findCourseDetailsById(id);
    }

    @Override
    public Student findStudentDetailsById(int id) {
        return studentCourseDAO.findStudentDetailsById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentCourseDAO.updateStudent(student);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        studentCourseDAO.deleteCourseById(id);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentCourseDAO.deleteStudentById(id);
    }
}
