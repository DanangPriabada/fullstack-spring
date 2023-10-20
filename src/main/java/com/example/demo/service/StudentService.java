package com.example.demo.service;

import com.example.demo.model.Student;
import java.util.List;

/**
 * Student service interface
 */
public interface StudentService {
    /**
     * Saves a student
     * @param student Student object to be saved
     */
    public void save(Student student);

    /**
     * Deletes a student by id
     * @param id Student id
     */
    public void delete(Integer id);

    /**
     * Gets a student by id
     * @param id Student id
     * @return Student object
     */
    public Student get(Integer id);

    /**
     * Lists all students
     * @return List of students
     */
    public List<Student> listAll();
}