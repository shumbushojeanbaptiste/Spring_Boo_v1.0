package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    @GetMapping("/age")
    public List<Student> getStudentsOlderThan(@RequestParam int age) {
        return repo.findStudentsOlderThan(age);
    }
    
}
