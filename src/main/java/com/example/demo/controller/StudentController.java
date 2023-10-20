package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Gets all students
     *
     * @return List of students
     */
    @GetMapping("/get_all")
    public List<Student> list() {
        return studentService.listAll();
    }

    /**
     * Adds a new student
     *
     * @param student Student object to be added
     * @return String message indicating success
     */
    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.save(student);
        return "New Student Added " + student.getName() + " ID " + student.getId();
    }

    /**
     * Gets a student by id
     *
     * @param id Student id
     * @return ResponseEntity containing student object or NOT_FOUND status
     */
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Object>(student, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            // Create a JSON response body with the error message
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("error", "Student with id " + id + " is not found");

            // Return a ResponseEntity with the error body and NOT_FOUND status
            return new ResponseEntity<Object>(errorBody, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Gets a student by id
     *
     * @param id Student id
     * @return ResponseEntity containing student object or NOT_FOUND status
     * http://localhost:{port}/api/student/get?id={student-id}
     */
    @GetMapping("/get")
    public ResponseEntity<Object> getStudent(@RequestParam("id") Integer id) {
        try {
            Student student = studentService.get(id);

            // Create a JSON response body with the success message
            Map<String, String> successBody = new LinkedHashMap<>();
            successBody.put("ID", String.valueOf(student.getId()));
            successBody.put("studentName", student.getName());
            successBody.put("studentAddress", student.getAddress());

            return new ResponseEntity<Object>(successBody, HttpStatus.OK);

        } catch (NoSuchElementException e) {

            // Create a JSON response body with the error message
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("error", "Student with id " + id + " is not found");

            // Return a ResponseEntity with the error body and NOT_FOUND status
            return new ResponseEntity<Object>(errorBody, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates a student
     *
     * @param student Student object to be updated
     * @return ResponseEntity containing student object or NOT_FOUND status
     */
    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Student student) {
        try {

            // Get existing student by id
            Student existingStudent = studentService.get(student.getId());

            // Update the existing student
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());

            // Create a JSON response body with the success message
            Map<String, String> successBody = new HashMap<>();
            successBody.put("success", "Student with id " + student.getId() + " is updated");

            // Save Student Changes
            studentService.save(existingStudent);

            return new ResponseEntity<Object>(successBody, HttpStatus.OK);

        } catch (NoSuchElementException e) {

            // Create a JSON response body with the error message
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("error", "Student with id " + student.getId() + " is not found");

            // Return a ResponseEntity with the error body and NOT_FOUND status
            return new ResponseEntity<Object>(errorBody, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates a student
     *
     * @param student Student object to be updated
     * @return ResponseEntity containing student object or NOT_FOUND status
     */
    @PutMapping("/update/with_id")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @RequestParam("id") Integer id) {
        try {

            // Get existing student by id
            Student existingStudent = studentService.get(id);

            // Update the existing student
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());

            // Create a JSON response body with the error message
            Map<String, String> successBody = new HashMap<>();
            successBody.put("success", "Student with id " + id + " is updated");

            // Save Student Changes
            studentService.save(existingStudent);

            return new ResponseEntity<Object>(successBody, HttpStatus.OK);

        } catch (NoSuchElementException e) {

            // Create a JSON response body with the error message
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("error", "Student with id " + id + " is not found");

            // Return a ResponseEntity with the error body and NOT_FOUND status
            return new ResponseEntity<Object>(errorBody, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a student by id
     *
     * @param id Student id
     * @return String message indicating success
     */
    @DeleteMapping("/delete/id/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.delete(id);
        return "Deleted Student with id " + id;
    }

    /**
     * Deletes a student by id
     *
     * @param id Student id
     * @return String message indicating success
     * http://localhost:{port}/api/student/delete?id={student-id}
     */
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") Integer id) {
        studentService.delete(id);
        return "Deleted Student with id " + id;
    }

}