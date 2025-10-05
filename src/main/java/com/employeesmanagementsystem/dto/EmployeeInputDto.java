package com.employeesmanagementsystem.dto;

public class EmployeeInputDto {
    private String name;
    private String email;
    private String phone;
    private double salary;
    private int departmentId;

    // Constructors
    public EmployeeInputDto() {
    }

    public EmployeeInputDto(String name, String email, String phone, double salary, int departmentId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}