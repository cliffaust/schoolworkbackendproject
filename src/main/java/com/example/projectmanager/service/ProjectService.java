package com.example.projectmanager.service;

import com.example.projectmanager.exception.UserNotFoundException;
import com.example.projectmanager.model.Project;
import com.example.projectmanager.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project addProject(Project project) {
        project.setProjectNumber(UUID.randomUUID().toString());
        return projectRepo.save(project);
    }

    public List<Project> findAllProjects() {
        return projectRepo.findAll();
    }

    public Project updateProject(Project project) {
        return projectRepo.save(project);
    }

    public Project findProjectById(Long id) {
        return projectRepo.findProjectById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteProject(Long id) {
        projectRepo.deleteEpmloyeeById(id);
    }
}
