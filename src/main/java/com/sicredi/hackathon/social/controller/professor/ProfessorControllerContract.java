package com.sicredi.hackathon.social.controller.professor;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import com.sicredi.hackathon.social.dto.response.professor.CadastrarProfessorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProfessorControllerContract {


    @ApiOperation(
            value = "Cadastra um professor.",
            notes = "Retorna a matricula do professor se conseguir efetuar o cadastro."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Professor cadastrado."),
            @ApiResponse(code = 400, message = "Parametros inválidos.")
    })
    public CadastrarProfessorResponse cadastrar(
            @RequestBody CadastrarProfessorRequest cadastrarProfessorRequest);


    @ApiOperation(
            value = "Busca os dados de um professor",
            notes = "Busca utilizando a matrícula do professor"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados do professor."),
            @ApiResponse(code = 400, message = "Parametros inválidos."),
            @ApiResponse(code = 404, message = "Professor não encontrado/exisste.")
    })
    public ProfessorDTO consultar(
            @ApiParam(value = "matrícula do professor", required = true)
            @PathVariable("id") String id);

}
