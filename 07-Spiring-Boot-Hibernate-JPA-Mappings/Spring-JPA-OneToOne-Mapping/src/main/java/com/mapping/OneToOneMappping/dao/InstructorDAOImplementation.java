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
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

}
