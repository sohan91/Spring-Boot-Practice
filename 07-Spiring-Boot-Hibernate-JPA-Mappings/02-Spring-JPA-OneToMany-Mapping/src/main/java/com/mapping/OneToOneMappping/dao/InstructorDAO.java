package com.mapping.OneToOneMappping.dao;

import com.mapping.OneToOneMappping.entity.Instructor;

public interface InstructorDAO {
    void saveInstructor(Instructor instructor);
    Instructor findById(int id);
}
