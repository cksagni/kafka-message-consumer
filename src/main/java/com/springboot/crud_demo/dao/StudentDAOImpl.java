package com.springboot.crud_demo.dao;

import com.springboot.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);

        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }

    @Override
    public Student save(Student student) {
        return this.entityManager.merge(student);
    }

    @Override
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
