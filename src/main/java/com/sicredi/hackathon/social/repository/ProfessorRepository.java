package com.sicredi.hackathon.social.repository;


import com.sicredi.hackathon.social.entity.ProfessorEntity;
import org.springframework.data.repository.Repository;

public interface ProfessorRepository extends Repository<ProfessorEntity, Integer> {

    ProfessorEntity save(ProfessorEntity professorEntity);

    ProfessorEntity findByMatricula(String matricula);

}
