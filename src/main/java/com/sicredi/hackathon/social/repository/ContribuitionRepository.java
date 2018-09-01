package com.sicredi.hackathon.social.repository;


import com.sicredi.hackathon.social.entity.ContribuitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContribuitionRepository extends JpaRepository<ContribuitionEntity, Long> {

}
