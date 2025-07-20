package com.mapping.OneToOneMappping.repository;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Course;
import com.mapping.OneToOneMappping.entity.Instructor;
import com.mapping.OneToOneMappping.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DAOImplementation implements InstructorDAO {

    private final EntityManager manager;

    @Autowired
    public DAOImplementation(EntityManager theManager)
    {
        manager = theManager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return manager.find(Instructor.class,id);
    }

    @Override
    public List<Course> findListOfCoursesById(int id) {
        TypedQuery<Course> courseTypedQuery = manager.createQuery("From Course where instructor.id=:theId",Course.class);
        courseTypedQuery.setParameter("theId",id);
        return courseTypedQuery.getResultList();
    }

    @Override
    public Course findCourseById(int id) {
        return manager.find(Course.class,id);
    }

    @Override
    public Instructor findInstructorUsingFetchById(int id) {
        TypedQuery<Instructor> instructorTypedQuery = manager.createQuery("SELECT i FROM Instructor i JOIN FETCH " +
                "                                                            i.courses WHERE i.id = :theId",Instructor.class);
                                                                            //courses-- field name in Instructor
        instructorTypedQuery.setParameter("theId",id);
        return instructorTypedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        manager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        manager.merge(course);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = manager.find(Instructor.class,id);
        List<Course> courses = instructor.getCourses();
        for(Course list:courses)
        {
            list.setInstructor(null);
        }
        manager.remove(instructor);
    }

    @Transactional
    @Override
    public void deleteCourseById(int id) {
        Course course = manager.find(Course.class,id);
        manager.remove(course);
    }

    @Override
    @Transactional
    public void saveReviewsOnCourse(Course course) {
        manager.persist(course);
    }

    @Override
    public Course findCourseWithReviewById(int id) {
        TypedQuery<Course> courseTypedQuery = manager.createQuery("SELECT c FROM Course c JOIN FETCH " +
                                                                    "c.reviewList WHERE c.id = :theId",Course.class);
        courseTypedQuery.setParameter("theId",id);
        return courseTypedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourseWithReviewById(int id) {
      Course course = manager.find(Course.class,id);
      manager.remove(course);
    }
}

