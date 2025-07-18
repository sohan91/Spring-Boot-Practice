package com.mapping.OneToOneMappping.dao;

import com.mapping.OneToOneMappping.entity.Instructor;
import com.mapping.OneToOneMappping.entity.InstructorDetails;

public interface InstructorDAO {
    void saveInstructor(Instructor instructor);
    Instructor findById(int id);
    void deleteInstructorById(int id);
    InstructorDetails findInstructorDetailsById(int id);
    void saveInstructorDetails(InstructorDetails details);
    void deleteInstructorDetailsById(int id);
}
