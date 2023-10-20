package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student get(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> listAll() {
        Iterable<Student> students = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        students.forEach(studentList::add);
        return studentList;
    }

}