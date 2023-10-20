package com.example.demo.service;

import com.example.demo.model.Student;
import java.util.List;

public interface StudentService {
    public void save(Student student);
    public void delete(Integer id);
    public Student get(Integer id);
    public List<Student> listAll();
}