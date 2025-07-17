package com.mapping.OneToOneMappping.service;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Instructor;
import com.mapping.OneToOneMappping.entity.InstructorDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
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
    public void save(Instructor instructor) {
        dao.save(instructor);
    }

}
