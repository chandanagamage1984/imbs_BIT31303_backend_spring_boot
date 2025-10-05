package com.employeesmanagementsystem.service;

import com.employeesmanagementsystem.model.Project;
import com.employeesmanagementsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(int id, Project project) {
        if (projectRepository.existsById(id)) {
            project.setProjectId(id);
            return projectRepository.save(project);
        }
        return null;
    }

    public boolean deleteProject(int id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(int id) {
        return projectRepository.existsById(id);
    }
}