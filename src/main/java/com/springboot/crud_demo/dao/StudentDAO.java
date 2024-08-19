package com.springboot.crud_demo.dao;

import com.springboot.crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findStudentByLastName(String lastName);

    void delete(Integer id);

    int deleteAll();
}
