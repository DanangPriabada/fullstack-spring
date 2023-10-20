package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> list() {
        return studentService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.save(student);
        return "New Student Added " + student.getName() + " ID " + student.getId();
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        try {

            // Get existing student by id
            Student existingStudent = studentService.get(student.getId());

            // Update the existing student
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());

            // Save Student Changes
            studentService.save(existingStudent);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.delete(id);
        return "Deleted Student with id " + id;
    }

}