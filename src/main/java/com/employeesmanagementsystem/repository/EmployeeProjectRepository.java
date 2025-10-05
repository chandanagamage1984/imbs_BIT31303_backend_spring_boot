package com.employeesmanagementsystem.repository;

import com.employeesmanagementsystem.dto.EmployeeProjectDetailDto;
import com.employeesmanagementsystem.model.EmployeeProject;
import com.employeesmanagementsystem.model.EmployeeProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, EmployeeProjectId> {

        @Query("SELECT new com.employeesmanagementsystem.dto.EmployeeProjectDetailDto(" +
                        "e.employeeId, e.name, e.email, e.phone, d.name, d.location, p.projectName, p.startDate, p.endDate) "
                        +
                        "FROM EmployeeProject ep JOIN ep.employee e JOIN e.department d JOIN ep.project p")
        List<EmployeeProjectDetailDto> findAllEmployeeProjectDetails();

        @Query("SELECT new com.employeesmanagementsystem.dto.EmployeeProjectDetailDto(" +
                        "e.employeeId, e.name, e.email, e.phone, d.name, d.location, p.projectName, p.startDate, p.endDate) "
                        +
                        "FROM EmployeeProject ep JOIN ep.employee e JOIN e.department d JOIN ep.project p " +
                        "WHERE e.employeeId = :employeeId")
        List<EmployeeProjectDetailDto> findEmployeeProjectDetailsByEmployeeId(@Param("employeeId") int employeeId);

        @Query("SELECT new com.employeesmanagementsystem.dto.EmployeeProjectDetailDto(" +
                        "e.employeeId, e.name, e.email, e.phone, d.name, d.location, p.projectName, p.startDate, p.endDate) "
                        +
                        "FROM EmployeeProject ep JOIN ep.employee e JOIN e.department d JOIN ep.project p " +
                        "WHERE p.projectId = :projectId")
        List<EmployeeProjectDetailDto> findEmployeeProjectDetailsByProjectId(@Param("projectId") int projectId);

        boolean existsByEmployeeEmployeeIdAndProjectProjectId(int employeeId, int projectId);

        Optional<EmployeeProject> findByEmployeeEmployeeIdAndProjectProjectId(int employeeId, int projectId);
}