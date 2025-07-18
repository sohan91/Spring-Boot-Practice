package com.mapping.OneToOneMappping.repository;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Instructor;
import com.mapping.OneToOneMappping.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDAOImplementation implements InstructorDAO {

    private final EntityManager entityManager;


    @Autowired
    public InstructorDAOImplementation(EntityManager manager)
    {
        entityManager = manager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
      entityManager.remove(instructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetails.class,id);
    }

    @Override
    @Transactional
    public void saveInstructorDetails(InstructorDetails details) {
        entityManager.persist(details);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int id) {
        entityManager.remove(entityManager.find(InstructorDetails.class,id));
    }


}
