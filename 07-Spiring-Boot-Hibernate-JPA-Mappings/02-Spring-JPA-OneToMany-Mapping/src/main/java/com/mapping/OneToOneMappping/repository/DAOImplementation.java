package com.mapping.OneToOneMappping.repository;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}

