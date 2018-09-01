package com.sicredi.hackathon.social.fixture.dto;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ProfessorDTOFixture {

    private final ProfessorDTO.ProfessorDTOBuilder builder = ProfessorDTO.builder();

    public static ProfessorDTOFixture get() {
        return new ProfessorDTOFixture();
    }

    public ProfessorDTOFixture random() {
        builder.idProfessor(RandomUtils.nextInt(0, 1000))
               .nome(RandomStringUtils.randomAlphabetic(30))
               .matricula(RandomStringUtils.randomAlphabetic(10));
        return this;
    }

    public List<ProfessorDTO> randomList(int size) {
        List<ProfessorDTO> list = newArrayList();
        for (int i = 0; i < size; i++) {
            list.add(random().build());
        }
        return list;
    }

    public ProfessorDTOFixture id(Integer id) {
        builder.idProfessor(id);
        return this;
    }

    public ProfessorDTOFixture nome(String nome) {
        builder.nome(nome);
        return this;
    }

    public ProfessorDTOFixture matricula(String matricula) {
        builder.matricula(matricula);
        return this;
    }


    public ProfessorDTO build() {
        return builder.build();
    }

}
