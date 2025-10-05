package com.employeesmanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_projects")
public class EmployeeProject {

    @EmbeddedId
    private EmployeeProjectId id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    // Constructors
    public EmployeeProject() {
    }

    public EmployeeProject(Employee employee, Project project) {
        this.employee = employee;
        this.project = project;
        this.id = new EmployeeProjectId(employee.getEmployeeId(), project.getProjectId());
    }

    // Getters and Setters
    public EmployeeProjectId getId() {
        return id;
    }

    public void setId(EmployeeProjectId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}