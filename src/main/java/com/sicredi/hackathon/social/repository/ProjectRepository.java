package com.sicredi.hackathon.social.repository;

import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findAllByOwner_Username(String username);

    @Query("SELECT project FROM ProjectEntity project WHERE project.owner.username != :username AND project.type = com.sicredi.hackathon.social.domain.ProjectType.PUBLIC")
    List<ProjectEntity> findProjectsPublicByUsername(@Param("username") String username);

    //@Query("SELECT project FROM ProjectEntity project WHERE project.owner.username != :username AND :username IN project.contribuitors.username")
    //List<ProjectEntity> findProjectsSharedWithMe(@Param("username") String username);

    List<ProjectEntity> findAllByOwnerIsNotAndContribuitorsContains(UserEntity user1, UserEntity user2);

}
