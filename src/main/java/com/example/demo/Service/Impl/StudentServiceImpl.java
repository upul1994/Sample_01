package com.example.demo.Service.Impl;


import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

