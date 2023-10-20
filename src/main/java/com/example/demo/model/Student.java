package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Student entity class
 */
@Entity
public class Student {

    /**
     * Student id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Student name
     */
    private String name;

    /**
     * Student address
     */
    private String address;

    /**
     * Default constructor
     */
    public Student() {
    }

    /**
     * Getter for student id
     * @return Student id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for student id
     * @param id Student id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for student name
     * @return Student name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for student name
     * @param name Student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for student address
     * @return Student address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for student address
     * @param address Student address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}