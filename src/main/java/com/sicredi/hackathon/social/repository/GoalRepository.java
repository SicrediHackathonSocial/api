package com.sicredi.hackathon.social.repository;


import com.sicredi.hackathon.social.entity.ProjectEntity;
import org.springframework.data.repository.Repository;

public interface GoalRepository extends Repository<ProjectEntity, Long> {

    ProjectEntity save(ProjectEntity goal);

    ProjectEntity findById(Long id);

}
