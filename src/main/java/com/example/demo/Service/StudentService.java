package com.example.demo.Service;

import com.example.demo.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student save(Student student);
    void delete(Long id);
}

