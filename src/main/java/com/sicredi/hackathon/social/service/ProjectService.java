package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.domain.ProjectStatus;
import com.sicredi.hackathon.social.domain.ProjectType;
import com.sicredi.hackathon.social.dto.request.EditProjectRequest;
import com.sicredi.hackathon.social.dto.request.RegisterProjectRequest;
import com.sicredi.hackathon.social.dto.response.RegisterProjectResponse;
import com.sicredi.hackathon.social.entity.ContribuitionEntity;
import com.sicredi.hackathon.social.entity.GoalEntity;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.repository.ContribuitionRepository;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ContribuitionRepository contribuitionRepository;

    @Autowired
    private UserService userService;

    public RegisterProjectResponse register(final String username, final RegisterProjectRequest request) {

        UserEntity owner = userService.findUserByUsername(username);
        ProjectEntity projectEntity = ProjectEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .type(request.getType())
                .owner(owner)
                .status(ProjectStatus.EM_ANDAMENTO)
                .build();

        projectEntity = projectRepository.save(projectEntity);

        return RegisterProjectResponse.builder()
                .idProject(projectEntity.getId())
                .build();
    }

    public ResponseEntity edit(final String username, final EditProjectRequest request) {

        ProjectEntity projectEntity = ProjectEntity.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .type(request.getType())
                .build();

        projectRepository.save(projectEntity);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ProjectEntity find(final Long id) {
        ProjectEntity project = projectRepository.findById(id).orElseThrow(NotFoundException::new);

        return project;

    }

    public ProjectEntity findOnePublicProject(final String usernameOwner) {

        final UserEntity user = userService.findUserByUsername(usernameOwner);
        final List<ProjectEntity> publics = projectRepository.findAllByTypeWithoutUser(ProjectType.PUBLIC, usernameOwner);

        return publics.stream()
                .filter(p -> !p.getContribuitors().contains(user) && !isUserContribuitor(user, p.getGoals()))
                .findFirst()
                .orElseGet(null);
    }

    private Boolean isUserContribuitor(final UserEntity user, final List<GoalEntity> goals){
        return goals.stream()
                .anyMatch(g -> g.getContribuitions().stream().anyMatch(c -> c.getContribuitor().equals(user)));
    }

    public List<ProjectEntity> findAllPublic() {
        return projectRepository.findAllByType(ProjectType.PUBLIC);
    }

    public ProjectEntity delete(final String username, final Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(NotFoundException::new);

        projectRepository.delete(projectEntity);

        return projectEntity;
    }
}

