package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import com.sicredi.hackathon.social.dto.response.professor.CadastrarProfessorResponse;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.mapper.dto.ProfessorDTOMapper;
import com.sicredi.hackathon.social.mapper.entity.ProfessorEntityMapper;
import com.sicredi.hackathon.social.service.validator.ProfessorServiceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorEntityMapper professorEntityMapper;

    @Autowired
    private ProfessorDTOMapper professorDTOMapper;

    public CadastrarProfessorResponse cadastrar(CadastrarProfessorRequest request) {
        log.info("Cadastrando professor: {}", request);
        ProfessorServiceValidator.validarRequestCadastrar(request);

        ProfessorEntity professorEntity = professorEntityMapper.map(request);

        professorEntity = professorRepository.save(professorEntity);

        log.info("Professor Cadastrado: {}", professorEntity.getIdProfessor());
        log.debug("Professor: {}", professorEntity);
        return CadastrarProfessorResponse.builder()
                                         .matricula(professorEntity.getMatricula())
                                         .build();

    }

    public ProfessorDTO consultar(String matricula) {
        ProfessorServiceValidator.validarRequestConsultar(matricula);

        Optional<ProfessorEntity> opProfessorEntity = ofNullable(professorRepository.findByMatricula(matricula));

        ProfessorEntity professorEntity = opProfessorEntity.orElseThrow(NotFoundException::new);

        return professorDTOMapper.map(professorEntity);

    }
}
