package com.sicredi.hackathon.social.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class ProfessorDTO implements Serializable {

    private static final long serialVersionUID = 5830093589195548823L;

    private final Integer idProfessor;
    private final String matricula;
    private final String nome;

}
