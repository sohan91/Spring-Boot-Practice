package com.example.cruddemo.dboperation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.EntityReference;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudDAOImplementation implements StudentDAO{
    private EntityManager manager;

    StudDAOImplementation(EntityManager theManager)
    {
        manager = theManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        manager.persist(student);
    }

    @Override
    public Student getDetails(Integer id) {
        return manager.find(Student.class,id);
    }

    @Override
    public List<Student> getAllStudentDetails() {
        TypedQuery<Student> query = manager.createQuery("FROM Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> getOrderByStudentName() {
        TypedQuery<Student> query = manager.createQuery("FROM Student order by firstName,lastName",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        TypedQuery<Student> query = manager.createQuery("FROM Student where firstName=:thedata",Student.class);
        query.setParameter("thedata",firstName);
        return query.getResultList();
    }

}
