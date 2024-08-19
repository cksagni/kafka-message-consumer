package com.springboot.crud_demo.service;

import com.springboot.crud_demo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    List<Student> findByLastName(String lastName);

    Student save(Student student);

    void deleteById(int id);

    int deleteAll();
}
