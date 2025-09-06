package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Student> students = service.getAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>("No students found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Student student = service.getById(id);
        if (student == null) {
            return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student) {
        if (student == null) {
            return new ResponseEntity<>("Student data cannot be null", HttpStatus.BAD_REQUEST);
        }
        Student saved = service.save(student);
        return new ResponseEntity<>("Student created successfully: " + saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student) {
        Student existing = service.getById(id);
        if (existing == null) {
            return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
        student.setId(id);
        Student updated = service.save(student);
        return new ResponseEntity<>("Student updated successfully: " + updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Student existing = service.getById(id);
        if (existing == null) {
            return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>("Student with ID " + id + " deleted successfully", HttpStatus.OK);
    }
}
