package com.employeesmanagementsystem.service;

import com.employeesmanagementsystem.dto.EmployeeInputDto;
import com.employeesmanagementsystem.dto.EmployeeWithDepartmentDto;
import com.employeesmanagementsystem.model.Department;
import com.employeesmanagementsystem.model.Employee;
import com.employeesmanagementsystem.repository.DepartmentRepository;
import com.employeesmanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<EmployeeWithDepartmentDto> getAllEmployees() {
        return employeeRepository.findAllEmployeesWithDepartment();
    }

    public Optional<EmployeeWithDepartmentDto> getEmployeeById(int id) {
        return employeeRepository.findEmployeeWithDepartmentById(id);
    }

    public EmployeeWithDepartmentDto createEmployee(EmployeeInputDto employeeInput) {
        Optional<Department> department = departmentRepository.findById(employeeInput.getDepartmentId());
        if (department.isEmpty()) {
            throw new RuntimeException("Invalid DepartmentId");
        }

        Employee employee = new Employee();
        employee.setName(employeeInput.getName());
        employee.setEmail(employeeInput.getEmail());
        employee.setPhone(employeeInput.getPhone());
        employee.setSalary(employeeInput.getSalary());
        employee.setDepartment(department.get());

        Employee savedEmployee = employeeRepository.save(employee);
        return employeeRepository.findEmployeeWithDepartmentById(savedEmployee.getEmployeeId()).orElse(null);
    }

    public EmployeeWithDepartmentDto updateEmployee(int id, EmployeeInputDto employeeInput) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isEmpty()) {
            return null;
        }

        Optional<Department> department = departmentRepository.findById(employeeInput.getDepartmentId());
        if (department.isEmpty()) {
            throw new RuntimeException("Invalid DepartmentId");
        }

        Employee employee = existingEmployee.get();
        employee.setName(employeeInput.getName());
        employee.setEmail(employeeInput.getEmail());
        employee.setPhone(employeeInput.getPhone());
        employee.setSalary(employeeInput.getSalary());
        employee.setDepartment(department.get());

        employeeRepository.save(employee);
        return employeeRepository.findEmployeeWithDepartmentById(id).orElse(null);
    }

    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(int id) {
        return employeeRepository.existsById(id);
    }
}