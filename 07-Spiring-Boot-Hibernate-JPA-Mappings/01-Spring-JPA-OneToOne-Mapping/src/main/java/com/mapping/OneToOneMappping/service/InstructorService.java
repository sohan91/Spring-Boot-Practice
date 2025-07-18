package com.mapping.OneToOneMappping.service;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Instructor;
import com.mapping.OneToOneMappping.entity.InstructorDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class InstructorService implements InstructorDAO {

    private InstructorDAO dao;
    @Autowired
public InstructorService(InstructorDAO dao)
{
    this.dao = dao;
}
    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        dao.saveInstructor(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        dao.deleteInstructorById(id);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return dao.findInstructorDetailsById(id);
    }

    @Override
    public void saveInstructorDetails(InstructorDetails details) {
        dao.saveInstructorDetails(details);
    }

    @Override
    public void deleteInstructorDetailsById(int id) {
        dao.deleteInstructorDetailsById(id);
    }

}
