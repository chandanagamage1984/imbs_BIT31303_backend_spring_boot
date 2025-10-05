package com.employeesmanagementsystem.service;

import com.employeesmanagementsystem.dto.EmployeeProjectDetailDto;
import com.employeesmanagementsystem.dto.EmployeeProjectInputDto;
import com.employeesmanagementsystem.dto.UpdateEmployeeProjectDto;
import com.employeesmanagementsystem.model.Employee;
import com.employeesmanagementsystem.model.EmployeeProject;
import com.employeesmanagementsystem.model.Project;
import com.employeesmanagementsystem.repository.EmployeeProjectRepository;
import com.employeesmanagementsystem.repository.EmployeeRepository;
import com.employeesmanagementsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProjectService {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<EmployeeProjectDetailDto> getAllEmployeeProjects() {
        return employeeProjectRepository.findAllEmployeeProjectDetails();
    }

    public List<EmployeeProjectDetailDto> getEmployeeProjectsByEmployee(int employeeId) {
        return employeeProjectRepository.findEmployeeProjectDetailsByEmployeeId(employeeId);
    }

    public List<EmployeeProjectDetailDto> getEmployeeProjectsByProject(int projectId) {
        return employeeProjectRepository.findEmployeeProjectDetailsByProjectId(projectId);
    }

    public EmployeeProjectDetailDto createEmployeeProject(EmployeeProjectInputDto employeeProjectInput) {
        // Validate that Employee exists
        Optional<Employee> employee = employeeRepository.findById(employeeProjectInput.getEmployeeId());
        if (employee.isEmpty()) {
            throw new RuntimeException("Invalid EmployeeId");
        }

        // Validate that Project exists
        Optional<Project> project = projectRepository.findById(employeeProjectInput.getProjectId());
        if (project.isEmpty()) {
            throw new RuntimeException("Invalid ProjectId");
        }

        // Check if the assignment already exists
        if (employeeProjectRepository.existsByEmployeeEmployeeIdAndProjectProjectId(
                employeeProjectInput.getEmployeeId(), employeeProjectInput.getProjectId())) {
            throw new RuntimeException("This employee is already assigned to this project.");
        }

        EmployeeProject employeeProject = new EmployeeProject(employee.get(), project.get());
        employeeProjectRepository.save(employeeProject);

        List<EmployeeProjectDetailDto> result = employeeProjectRepository
                .findEmployeeProjectDetailsByEmployeeId(employeeProjectInput.getEmployeeId());

        return result.stream()
                .filter(dto -> dto.getEmployeeId() == employeeProjectInput.getEmployeeId())
                .findFirst()
                .orElse(null);
    }

    public boolean deleteEmployeeProject(EmployeeProjectInputDto employeeProjectInput) {
        Optional<EmployeeProject> employeeProject = employeeProjectRepository
                .findByEmployeeEmployeeIdAndProjectProjectId(
                        employeeProjectInput.getEmployeeId(),
                        employeeProjectInput.getProjectId());

        if (employeeProject.isPresent()) {
            employeeProjectRepository.delete(employeeProject.get());
            return true;
        }
        return false;
    }

    public boolean updateEmployeeProject(UpdateEmployeeProjectDto updateDto) {
        // Find the existing assignment
        Optional<EmployeeProject> existingEmployeeProject = employeeProjectRepository
                .findByEmployeeEmployeeIdAndProjectProjectId(
                        updateDto.getOldEmployeeId(),
                        updateDto.getOldProjectId());

        if (existingEmployeeProject.isEmpty()) {
            return false;
        }

        // Validate new Employee exists
        if (!employeeRepository.existsById(updateDto.getNewEmployeeId())) {
            throw new RuntimeException("Invalid EmployeeId in new assignment");
        }

        // Validate new Project exists
        if (!projectRepository.existsById(updateDto.getNewProjectId())) {
            throw new RuntimeException("Invalid ProjectId in new assignment");
        }

        // Check if the new assignment already exists
        if (employeeProjectRepository.existsByEmployeeEmployeeIdAndProjectProjectId(
                updateDto.getNewEmployeeId(), updateDto.getNewProjectId())) {
            throw new RuntimeException("This employee is already assigned to this project.");
        }

        // Remove old assignment and create new one
        employeeProjectRepository.delete(existingEmployeeProject.get());

        Optional<Employee> newEmployee = employeeRepository.findById(updateDto.getNewEmployeeId());
        Optional<Project> newProject = projectRepository.findById(updateDto.getNewProjectId());

        if (newEmployee.isPresent() && newProject.isPresent()) {
            EmployeeProject newEmployeeProject = new EmployeeProject(newEmployee.get(), newProject.get());
            employeeProjectRepository.save(newEmployeeProject);
            return true;
        }

        return false;
    }
}