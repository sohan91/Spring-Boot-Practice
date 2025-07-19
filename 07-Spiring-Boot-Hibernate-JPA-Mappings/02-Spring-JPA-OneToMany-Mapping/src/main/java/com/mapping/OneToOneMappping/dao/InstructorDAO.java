package com.mapping.OneToOneMappping.dao;

import com.mapping.OneToOneMappping.entity.Course;
import com.mapping.OneToOneMappping.entity.Instructor;

import java.util.List;

public interface InstructorDAO {
    void saveInstructor(Instructor instructor);
    Instructor findById(int id);
    List<Course> findListOfCoursesById(int id);
    Course findCourseById(int id);
    Instructor findInstructorUsingFetchById(int id);
    void updateInstructor(Instructor instructor);
    void updateCourse(Course course);
    void deleteInstructorById(int id);
    void deleteCourseById(int id);
}
