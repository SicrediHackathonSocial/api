package com.sicredi.hackathon.social.mapper.dto;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.entity.ProfessorEntity;
import com.sicredi.hackathon.social.mapper.Mapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ProfessorDTOMapper implements Mapper<ProfessorEntity, ProfessorDTO> {

    @Override
    public ProfessorDTO map(final ProfessorEntity from) {
        if (isNull(from)) {
            return null;
        }
        return ProfessorDTO.builder()
                           .idProfessor(from.getIdProfessor())
                           .matricula(from.getMatricula())
                           .nome(from.getNome())
                           .build();
    }
}
