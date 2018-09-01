package com.sicredi.hackathon.social.fixture.dto.request.professor;

import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import org.apache.commons.lang3.RandomStringUtils;

public class CadastrarProfessorRequestFixture {

    private final CadastrarProfessorRequest.CadastrarProfessorRequestBuilder builder = CadastrarProfessorRequest.builder();

    public static CadastrarProfessorRequestFixture get() {
        return new CadastrarProfessorRequestFixture();
    }

    public CadastrarProfessorRequestFixture random() {
        builder.nome(RandomStringUtils.randomAlphabetic(30))
               .matricula(RandomStringUtils.randomAlphabetic(10));
        return this;
    }

    public CadastrarProfessorRequestFixture nome(String nome) {
        builder.nome(nome);
        return this;
    }

    public CadastrarProfessorRequestFixture matricula(String matricula) {
        builder.matricula(matricula);
        return this;
    }


    public CadastrarProfessorRequest build() {
        return builder.build();
    }

}
