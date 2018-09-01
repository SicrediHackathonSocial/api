package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.dto.ProfessorDTO;
import com.sicredi.hackathon.social.dto.request.professor.CadastrarProfessorRequest;
import com.sicredi.hackathon.social.dto.response.professor.CadastrarProfessorResponse;
import com.sicredi.hackathon.social.entity.ProfessorEntity;
import com.sicredi.hackathon.social.exception.status.BadRequestException;
import com.sicredi.hackathon.social.fixture.dto.request.professor.CadastrarProfessorRequestFixture;
import com.sicredi.hackathon.social.fixture.entity.ProfessorEntityFixture;
import com.sicredi.hackathon.social.mapper.dto.ProfessorDTOMapper;
import com.sicredi.hackathon.social.mapper.entity.ProfessorEntityMapper;
import com.sicredi.hackathon.social.repository.ProfessorRepository;
import com.sicredi.hackathon.social.service.validator.ProfessorServiceValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(ProfessorServiceValidator.class)
public class ProfessorServiceTest {

    @InjectMocks
    private ProfessorService service;

    @Mock
    private ProfessorRepository professorRepository;

    @Mock
    private ProfessorEntityMapper professorEntityMapper;

    @Mock
    private ProfessorDTOMapper professorDTOMapper;

    @Captor
    private ArgumentCaptor<ProfessorEntity> professorEntityCaptor;

    private ProfessorEntity professorEntity;
    private CadastrarProfessorRequest cadastrarRequest;

    @Before
    public void setup() {
        ProfessorEntityFixture fixture = ProfessorEntityFixture.get().random();
        professorEntity = fixture.build();

        when(professorRepository.save(any(ProfessorEntity.class))).thenReturn(professorEntity);
        when(professorRepository.findByMatricula(any())).thenReturn(professorEntity);

        cadastrarRequest = CadastrarProfessorRequestFixture.get().random().build();
        fixture.matricula(cadastrarRequest.getMatricula());
        fixture.nome(cadastrarRequest.getNome());
        fixture.id(null);

        when(professorEntityMapper.map(any(CadastrarProfessorRequest.class))).thenReturn(fixture.build());
    }

    @Test(expected = BadRequestException.class)
    public void cadastrarErroRequestNull() {
        callCadastrarZeroInteractions(null);
    }

    @Test(expected = BadRequestException.class)
    public void cadastrarErroMatriculaNull() {
        CadastrarProfessorRequest request = CadastrarProfessorRequestFixture.get().random().matricula(null).build();
        callCadastrarZeroInteractions(request);
    }


    @Test(expected = BadRequestException.class)
    public void cadastrarErroMatriculaEmpty() {
        CadastrarProfessorRequest request = CadastrarProfessorRequestFixture.get().random().matricula("").build();
        callCadastrarZeroInteractions(request);
    }

    @Test(expected = BadRequestException.class)
    public void cadastrarErroNomeNull() {
        CadastrarProfessorRequest request = CadastrarProfessorRequestFixture.get().random().nome(null).build();
        callCadastrarZeroInteractions(request);
    }

    @Test(expected = BadRequestException.class)
    public void cadastrarErroNomeEmpty() {
        CadastrarProfessorRequest request = CadastrarProfessorRequestFixture.get().random().nome("").build();
        callCadastrarZeroInteractions(request);
    }

    @Test
    public void cadastrarSucesso() {
        CadastrarProfessorResponse response = service.cadastrar(cadastrarRequest);

        verify(professorRepository, times(1)).save(professorEntityCaptor.capture());

        assertNotNull(response);
        assertNotNull(response.getMatricula());
        assertNull(professorEntityCaptor.getValue().getIdProfessor());
        assertEquals(cadastrarRequest.getMatricula(), professorEntityCaptor.getValue().getMatricula());
        assertEquals(cadastrarRequest.getNome(), professorEntityCaptor.getValue().getNome());

    }

    @Test(expected = BadRequestException.class)
    public void buscarErroMatriculaNull() {
        callConsultarZeroInteractions(null);
    }

    @Test(expected = BadRequestException.class)
    public void buscarErroMatriculaEmpty() {
        callConsultarZeroInteractions("");
    }

    @Test
    public void buscarSucesso() {
        String matricula = randomAlphabetic(10);
        ProfessorDTO professor = service.consultar(matricula);

        verify(professorDTOMapper, times(1)).map(professorEntityCaptor.capture());

        assertNotNull(professorEntityCaptor.getValue());
        assertEquals(professorEntity, professorEntityCaptor.getValue());
    }

    private void callCadastrarZeroInteractions(CadastrarProfessorRequest request) {
        try {
            service.cadastrar(request);
        } finally {
            verifyZeroInteractions(professorRepository);
        }
    }

    private void callConsultarZeroInteractions(String matricula) {
        try {
            service.consultar(matricula);
        } finally {
            verifyZeroInteractions(professorRepository);
        }
    }
}