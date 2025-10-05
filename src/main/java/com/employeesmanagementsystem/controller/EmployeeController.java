package com.employeesmanagementsystem.controller;

import com.employeesmanagementsystem.dto.EmployeeInputDto;
import com.employeesmanagementsystem.dto.EmployeeWithDepartmentDto;
import com.employeesmanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeWithDepartmentDto>> getEmployees() {
        List<EmployeeWithDepartmentDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeWithDepartmentDto> getEmployee(@PathVariable int id) {
        Optional<EmployeeWithDepartmentDto> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> postEmployee(@RequestBody EmployeeInputDto employeeInput) {
        try {
            EmployeeWithDepartmentDto createdEmployee = employeeService.createEmployee(employeeInput);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putEmployee(@PathVariable int id, @RequestBody EmployeeInputDto employeeInput) {
        try {
            EmployeeWithDepartmentDto updatedEmployee = employeeService.updateEmployee(id, employeeInput);
            if (updatedEmployee != null) {
                return ResponseEntity.ok(updatedEmployee);
            }
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        if (employeeService.deleteEmployee(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}