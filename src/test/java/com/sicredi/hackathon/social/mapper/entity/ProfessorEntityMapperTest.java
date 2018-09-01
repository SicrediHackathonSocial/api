package com.sicredi.hackathon.social.mapper.entity;


import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import com.sicredi.hackathon.social.entity.ProfessorEntity;
import com.sicredi.hackathon.social.fixture.dto.ProfessorDTOFixture;
import com.sicredi.hackathon.social.fixture.dto.request.professor.CadastrarProfessorRequestFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorEntityMapperTest {

    @InjectMocks
    private ProfessorEntityMapper mapper;

    @Test
    public void deveRetornarNullCadastrarProfessorRequest() {
        final CadastrarProfessorRequest from = null;
        assertNull(mapper.map(from));
    }

    @Test
    public void deveRetornarNullProfessorDTO() {
        final ProfessorDTO from = null;
        assertNull(mapper.map(from));
    }

    @Test
    public void deveRetornarNullListProfessorDTO() {
        assertNull(mapper.mapList(null));
    }

    @Test
    public void deveRetornarSucessoCadastrarProfessorRequest() {
        final CadastrarProfessorRequest expected = CadastrarProfessorRequestFixture.get().random().build();
        final ProfessorEntity actual = mapper.map(expected);
        assertProfessor(actual, expected);
    }

    @Test
    public void deveRetornarSucessoProfessorDTO() {
        final ProfessorDTO expected = ProfessorDTOFixture.get().random().build();
        final ProfessorEntity actual = mapper.map(expected);
        assertProfessor(actual, expected);
    }

    @Test
    public void deveRetornarSucessoListProfessorDTO() {
        final List<ProfessorDTO> expected = ProfessorDTOFixture.get().randomList(nextInt(3, 8));
        final List<ProfessorEntity> actual = mapper.mapList(expected);
        assertProfessor(actual, expected);
    }

    private void assertProfessor(final List<ProfessorEntity> actual, final List<ProfessorDTO> expected) {
        assertNotNull(actual);
        assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertProfessor(actual.get(i), expected.get(i));
        }
    }

    private void assertProfessor(final ProfessorEntity actual, final CadastrarProfessorRequest expected) {
        assertNotNull(actual);
        assertEquals(expected.getMatricula(), actual.getMatricula());
        assertEquals(expected.getNome(), actual.getNome());
    }

    private void assertProfessor(final ProfessorEntity actual, final ProfessorDTO expected) {
        assertNotNull(actual);
        assertEquals(expected.getIdProfessor(), actual.getIdProfessor());
        assertEquals(expected.getMatricula(), actual.getMatricula());
        assertEquals(expected.getNome(), actual.getNome());
    }

}
