package com.sicredi.hackathon.social.repository;


import com.sicredi.hackathon.social.entity.ContribuitionEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContribuitionRepository extends JpaRepository<ContribuitionEntity, Long> {

    List<ContribuitionEntity> findAllByContribuitor(UserEntity user);
}
