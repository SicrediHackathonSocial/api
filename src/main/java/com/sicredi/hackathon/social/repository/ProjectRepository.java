package com.sicredi.hackathon.social.repository;

import com.sicredi.hackathon.social.domain.ProjectType;
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

    List<ProjectEntity> findAllByOwner_UsernameAndType(String username, ProjectType type);

    List<ProjectEntity> findAllByOwnerIsNotAndContribuitorsContains(UserEntity user1, UserEntity user2);

    List<ProjectEntity> findAllByType(ProjectType type);

    @Query("SELECT obj FROM ProjectEntity obj WHERE obj.type = :type AND obj.owner.username != :username")
    List<ProjectEntity> findAllByTypeWithoutUser(@Param("type") ProjectType type, @Param("username") String username);

}
