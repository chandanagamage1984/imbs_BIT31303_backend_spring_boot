package com.employeesmanagementsystem.controller;

import com.employeesmanagementsystem.dto.EmployeeProjectDetailDto;
import com.employeesmanagementsystem.dto.EmployeeProjectInputDto;
import com.employeesmanagementsystem.dto.UpdateEmployeeProjectDto;
import com.employeesmanagementsystem.service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeprojects")
public class EmployeeProjectsController {

    @Autowired
    private EmployeeProjectService employeeProjectService;

    @GetMapping
    public ResponseEntity<List<EmployeeProjectDetailDto>> getEmployeeProjects() {
        List<EmployeeProjectDetailDto> employeeProjects = employeeProjectService.getAllEmployeeProjects();
        return ResponseEntity.ok(employeeProjects);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeProjectDetailDto>> getEmployeeProjectsByEmployee(@PathVariable int employeeId) {
        List<EmployeeProjectDetailDto> employeeProjects = employeeProjectService
                .getEmployeeProjectsByEmployee(employeeId);
        if (employeeProjects.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeProjects);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<EmployeeProjectDetailDto>> getEmployeeProjectsByProject(@PathVariable int projectId) {
        List<EmployeeProjectDetailDto> employeeProjects = employeeProjectService
                .getEmployeeProjectsByProject(projectId);
        if (employeeProjects.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeProjects);
    }

    @PostMapping
    public ResponseEntity<?> postEmployeeProject(@RequestBody EmployeeProjectInputDto employeeProjectInput) {
        try {
            EmployeeProjectDetailDto createdEmployeeProject = employeeProjectService
                    .createEmployeeProject(employeeProjectInput);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployeeProject);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmployeeProject(@RequestBody EmployeeProjectInputDto employeeProjectInput) {
        if (employeeProjectService.deleteEmployeeProject(employeeProjectInput)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<?> putEmployeeProject(@RequestBody UpdateEmployeeProjectDto updateDto) {
        try {
            if (employeeProjectService.updateEmployeeProject(updateDto)) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}