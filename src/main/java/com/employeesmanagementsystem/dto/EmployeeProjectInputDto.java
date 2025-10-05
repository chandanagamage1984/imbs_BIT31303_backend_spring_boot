package com.employeesmanagementsystem.dto;

public class EmployeeProjectInputDto {
    private int employeeId;
    private int projectId;

    // Constructors
    public EmployeeProjectInputDto() {
    }

    public EmployeeProjectInputDto(int employeeId, int projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}