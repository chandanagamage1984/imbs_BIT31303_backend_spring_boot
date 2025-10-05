package com.employeesmanagementsystem.dto;

public class EmployeeWithDepartmentDto {
    private int employeeId;
    private String name;
    private String email;
    private String phone;
    private double salary;
    private String departmentName;
    private String location;

    // Constructors
    public EmployeeWithDepartmentDto() {
    }

    public EmployeeWithDepartmentDto(int employeeId, String name, String email, String phone,
            double salary, String departmentName, String location) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.departmentName = departmentName;
        this.location = location;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}