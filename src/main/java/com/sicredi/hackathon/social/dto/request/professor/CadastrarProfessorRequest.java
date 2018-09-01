package com.sicredi.hackathon.social.dto.request.professor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class CadastrarProfessorRequest {

    private final String nome;
    private final String matricula;

}
