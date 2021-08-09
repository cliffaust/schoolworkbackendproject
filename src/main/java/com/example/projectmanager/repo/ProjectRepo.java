package com.example.projectmanager.repo;

import com.example.projectmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    Optional<Project> findProjectById(Long id);

    @Transactional
    void deleteEpmloyeeById(Long id);
}
