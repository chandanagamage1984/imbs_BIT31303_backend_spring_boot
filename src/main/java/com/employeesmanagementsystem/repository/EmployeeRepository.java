package com.employeesmanagementsystem.repository;

import com.employeesmanagementsystem.dto.EmployeeWithDepartmentDto;
import com.employeesmanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

        @Query("SELECT new com.employeesmanagementsystem.dto.EmployeeWithDepartmentDto(" +
                        "e.employeeId, e.name, e.email, e.phone, e.salary, d.name, d.location) " +
                        "FROM Employee e JOIN e.department d")
        List<EmployeeWithDepartmentDto> findAllEmployeesWithDepartment();

        @Query("SELECT new com.employeesmanagementsystem.dto.EmployeeWithDepartmentDto(" +
                        "e.employeeId, e.name, e.email, e.phone, e.salary, d.name, d.location) " +
                        "FROM Employee e JOIN e.department d WHERE e.employeeId = :id")
        Optional<EmployeeWithDepartmentDto> findEmployeeWithDepartmentById(@Param("id") int id);
}