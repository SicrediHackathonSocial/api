package com.sicredi.hackathon.social.mapper.dto;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.fixture.entity.ProfessorEntityFixture;
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
public class ProfessorDTOMapperTest {

    @InjectMocks
    private ProfessorDTOMapper mapper;

    @Test
    public void deveRetornarNull() {
        assertNull(mapper.map(null));
    }

    @Test
    public void deveRetornarNullList() {
        assertNull(mapper.mapList(null));
    }

    @Test
    public void deveRetornarSucesso() {
        final ProfessorEntity expected = ProfessorEntityFixture.get().random().build();
        final ProfessorDTO actual = mapper.map(expected);
        assertProfessor(actual, expected);
    }

    @Test
    public void deveRetornarSucessoList() {
        final List<ProfessorEntity> expected = ProfessorEntityFixture.get().randomList(nextInt(3, 8));
        final List<ProfessorDTO> actual = mapper.mapList(expected);
        assertProfessor(actual, expected);
    }

    private void assertProfessor(final List<ProfessorDTO> actual, final List<ProfessorEntity> expected) {
        assertNotNull(actual);
        assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertProfessor(actual.get(i), expected.get(i));
        }
    }

    private void assertProfessor(final ProfessorDTO actual, final ProfessorEntity expected) {
        assertNotNull(actual);
        assertEquals(expected.getIdProfessor(), actual.getIdProfessor());
        assertEquals(expected.getMatricula(), actual.getMatricula());
        assertEquals(expected.getNome(), actual.getNome());
    }


}
