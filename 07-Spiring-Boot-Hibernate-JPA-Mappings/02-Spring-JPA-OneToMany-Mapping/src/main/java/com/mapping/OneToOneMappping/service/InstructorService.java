package com.mapping.OneToOneMappping.service;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Course;
import com.mapping.OneToOneMappping.entity.Instructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class InstructorService implements InstructorDAO {

    private final InstructorDAO instructorDAO;
    public InstructorService(InstructorDAO dao)
    {
        instructorDAO = dao;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        instructorDAO.saveInstructor(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return instructorDAO.findById(id);
    }

    @Override
    public List<Course> findListOfCoursesById(int id) {
        return instructorDAO.findListOfCoursesById(id);
    }

    @Override
    public Course findCourseById(int id) {
        return instructorDAO.findCourseById(id);
    }

    @Override
    public Instructor findInstructorUsingFetchById(int id) {
        return instructorDAO.findInstructorUsingFetchById(id);
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        instructorDAO.updateInstructor(instructor);
    }

    @Override
    public void updateCourse(Course course) {
        instructorDAO.updateCourse(course);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        instructorDAO.deleteInstructorById(id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        instructorDAO.deleteCourseById(id);
    }
}
