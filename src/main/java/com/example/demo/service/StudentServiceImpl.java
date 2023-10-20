package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Student service implementation
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    /**
     * Constructor
     *
     * @param studentRepository Student repository
     */
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Saves a student
     *
     * @param student Student object to be saved
     */
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    /**
     * Deletes a student by id
     *
     * @param id Student id
     */
    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    /**
     * Gets a student by id
     *
     * @param id Student id
     * @return Student object
     */
    @Override
    public Student get(Integer id) {
        return studentRepository.findById(id).get();
    }

    /**
     * Lists all students
     *
     * @return List of students
     */
    @Override
    public List<Student> listAll() {
        Iterable<Student> students = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        students.forEach(studentList::add);
        return studentList;
    }

}