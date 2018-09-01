package com.sicredi.hackathon.social.service.validator;

import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import com.sicredi.hackathon.social.exception.status.BadRequestException;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public final class ProfessorServiceValidator {

    public static void validarRequestCadastrar(CadastrarProfessorRequest request) {
        if (isNull(request)) {
            throw new BadRequestException("Request não pode ser nulo.");
        }

        if (isEmpty(request.getNome()) || isEmpty(request.getMatricula())) {
            throw new BadRequestException("Parâmetros inválidos.");
        }
    }

    public static void validarRequestConsultar(String matricula) {
        if (isEmpty(matricula)) {
            throw new BadRequestException("Matrícula é obrigatória para consultar um professor.");
        }
    }
}
