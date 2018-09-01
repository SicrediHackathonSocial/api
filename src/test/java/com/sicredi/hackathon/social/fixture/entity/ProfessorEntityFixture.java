package com.sicredi.hackathon.social.fixture.entity;

import com.sicredi.hackathon.social.entity.ProfessorEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ProfessorEntityFixture {

    private final ProfessorEntity.ProfessorEntityBuilder builder = ProfessorEntity.builder();

    public static ProfessorEntityFixture get() {
        return new ProfessorEntityFixture();
    }

    public ProfessorEntityFixture random() {
        builder.idProfessor(RandomUtils.nextInt(0, 1000))
               .nome(RandomStringUtils.randomAlphabetic(30))
               .matricula(RandomStringUtils.randomAlphabetic(10));
        return this;
    }

    public ProfessorEntityFixture id(Integer id) {
        builder.idProfessor(id);
        return this;
    }

    public ProfessorEntityFixture nome(String nome) {
        builder.nome(nome);
        return this;
    }

    public ProfessorEntityFixture matricula(String matricula) {
        builder.matricula(matricula);
        return this;
    }

    public ProfessorEntity build() {
        return builder.build();
    }

    public List<ProfessorEntity> randomList(int size) {
        List<ProfessorEntity> list = newArrayList();
        for (int i=0; i<size; i++){
            list.add(random().build());
        }
        return list;
    }
}
