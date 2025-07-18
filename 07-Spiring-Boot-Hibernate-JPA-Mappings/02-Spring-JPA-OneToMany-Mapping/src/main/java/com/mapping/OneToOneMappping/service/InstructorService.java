package com.mapping.OneToOneMappping.service;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Instructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class InstructorService implements InstructorDAO {

    private InstructorDAO instructorDAO;
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
}
