package com.sicredi.hackathon.social.mapper.entity;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import com.sicredi.hackathon.social.entity.ProfessorEntity;
import com.sicredi.hackathon.social.mapper.Mapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ProfessorEntityMapper implements Mapper<ProfessorDTO, ProfessorEntity> {


    @Override
    public ProfessorEntity map(final ProfessorDTO from) {
        if (isNull(from)) {
            return null;
        }
        return ProfessorEntity.builder()
                              .idProfessor(from.getIdProfessor())
                              .matricula(from.getMatricula())
                              .nome(from.getNome())
                              .build();
    }

    public ProfessorEntity map(final CadastrarProfessorRequest from) {
        if (isNull(from)) {
            return null;
        }
        return ProfessorEntity.builder()
                              .matricula(from.getMatricula())
                              .nome(from.getNome())
                              .build();
    }
}
