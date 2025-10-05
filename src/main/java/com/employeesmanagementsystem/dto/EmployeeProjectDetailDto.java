package com.employeesmanagementsystem.dto;

import java.time.LocalDate;

public class EmployeeProjectDetailDto {
    private int employeeId;
    private String employeeName;
    private String email;
    private String phone;
    private String departmentName;
    private String location;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;

    // Constructors
    public EmployeeProjectDetailDto() {
    }

    public EmployeeProjectDetailDto(int employeeId, String employeeName, String email, String phone,
            String departmentName, String location, String projectName,
            LocalDate startDate, LocalDate endDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.departmentName = departmentName;
        this.location = location;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}