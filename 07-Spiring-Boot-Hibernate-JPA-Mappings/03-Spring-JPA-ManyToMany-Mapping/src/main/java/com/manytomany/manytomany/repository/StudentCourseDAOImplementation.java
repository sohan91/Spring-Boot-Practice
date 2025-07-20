package com.manytomany.manytomany.repository;


import com.manytomany.manytomany.dao.StudentCourseDAO;
import com.manytomany.manytomany.entity.Course;
import com.manytomany.manytomany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentCourseDAOImplementation implements StudentCourseDAO {
    private final EntityManager theManager;

@Autowired
    public StudentCourseDAOImplementation(EntityManager entityManager)
    {
        theManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Course course) {
        theManager.persist(course);
    }

    @Override
    public Course findCourseDetailsById(int id) {
        TypedQuery<Course> courseTypedQuery = theManager.createQuery("SELECT c FROM Course c " +
                "JOIN FETCH c.studentList WHERE c.id = :theId", Course.class);
        courseTypedQuery.setParameter("theId",id);
        return courseTypedQuery.getSingleResult();
    }

    @Override
    public Student findStudentDetailsById(int id) {
        TypedQuery<Student> studentTypedQuery = theManager.createQuery("SELECT s FROM Student s " +
                "JOIN FETCH s.courseList WHERE s.id = :theId", Student.class);
        studentTypedQuery.setParameter("theId",id);
        return studentTypedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        theManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = theManager.find(Course.class,id);
        List<Student> studentList = course.getStudentList();
        for(Student students : studentList)
        {
            students.getCourseList().remove(course);
        }
        theManager.remove(course);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {

        Student student = theManager.find(Student.class,id);
        if(student != null) {
            List<Course> coursesList = student.getCourseList();
            for (Course course : coursesList) {
                course.getStudentList().remove(student);
            }
        }
        theManager.remove(student);
    }
}

