package com.springboot.crud_demo.service;

import com.springboot.crud_demo.dao.StudentDAO;
import com.springboot.crud_demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO){
        this.studentDAO = theStudentDAO;
    }

    @Override
    public List<Student> findAll() {
        return this.studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return this.studentDAO.findById(id);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return this.studentDAO.findStudentByLastName(lastName);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return this.studentDAO.save(student);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        this.studentDAO.delete(id);
    }

    @Transactional
    @Override
    public int deleteAll() {
        return this.studentDAO.deleteAll();
    }


}
