package com.sicredi.hackathon.social.controller.professor;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import com.sicredi.hackathon.social.dto.response.professor.CadastrarProfessorResponse;
import com.sicredi.hackathon.social.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/professor")
public class ProfessorController implements ProfessorControllerContract {

    @Autowired
    private ProfessorService professorService;

    @Override
    @PostMapping
    public CadastrarProfessorResponse cadastrar(CadastrarProfessorRequest cadastrarProfessorRequest) {
        return professorService.cadastrar(cadastrarProfessorRequest);
    }

    @Override
    @GetMapping("/{matricula}")
    public ProfessorDTO consultar(String matricula) {
        return professorService.consultar(matricula);
    }
}
