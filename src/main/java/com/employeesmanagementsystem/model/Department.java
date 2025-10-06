package com.employeesmanagementsystem.model;

import jakarta.persistence.*;
// import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    // @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    // private List<Employee> employees;

    // Constructors
    public Department() {
    }

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // public List<Employee> getEmployees() {
    // return employees;
    // }

    // public void setEmployees(List<Employee> employees) {
    // this.employees = employees;
    // }
}