package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.domain.ProjectStatus;
import com.sicredi.hackathon.social.domain.ProjectType;
import com.sicredi.hackathon.social.dto.request.EditProjectRequest;
import com.sicredi.hackathon.social.dto.request.RegisterProjectRequest;
import com.sicredi.hackathon.social.dto.response.EstimatedConclusionDateResponse;
import com.sicredi.hackathon.social.dto.response.RegisterProjectResponse;
import com.sicredi.hackathon.social.entity.ContribuitionEntity;
import com.sicredi.hackathon.social.entity.GoalEntity;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.BadRequestException;
import com.sicredi.hackathon.social.exception.status.ForbiddenException;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.repository.ContribuitionRepository;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ContribuitionRepository contribuitionRepository;

    @Autowired
    private UserService userService;

    private static final Integer DAYS_AVG_CONTRIBUITIONS = 30;

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

        UserEntity user = userService.findUserByUsername(usernameOwner);
        List<ProjectEntity> publics;

        Integer random = new Random().nextInt();
        System.out.println("Random " + random);
        if (random % 2 == 0 && !usernameOwner.equalsIgnoreCase("ARC")) {
            publics = projectRepository.findAllByOwner_Username("ARC");
            return publics.stream()
                    .filter(p -> !p.getContribuitors().contains(user) && !isUserContribuitor(user, p.getGoals()))
                    .findFirst()
                    .orElseGet(() -> new ProjectEntity());
        } else {
            publics = projectRepository.findAllByTypeWithoutUser(ProjectType.PUBLIC, usernameOwner);
            return publics.stream()
                    .filter(p -> !p.getContribuitors().contains(user) &&
                            !isUserContribuitor(user, p.getGoals()) &&
                            !p.getOwner().getUsername().equalsIgnoreCase("ARC"))
                    .findFirst()
                    .orElseGet(() -> new ProjectEntity());

        }
    }

    private Boolean isUserContribuitor(final UserEntity user, final List<GoalEntity> goals) {
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

    public void addMembership(final String username, final Long idProject){
        ProjectEntity project = find(idProject);

        if (project.getOwner().getUsername().equals(username)){
            throw new ForbiddenException();
        }

        if (!ProjectType.SHARED.equals(project.getType())){
            throw new BadRequestException();
        }

        UserEntity user = userService.findUserByUsername(username);
        if (project.getContribuitors().contains(user)){
            throw new BadRequestException();
        }

        project.getContribuitors().add(user);
        projectRepository.save(project);
    }

    public EstimatedConclusionDateResponse estimateConclusionDate(final String username, final Long id) {
        ProjectEntity project = projectRepository.findByIdAndOwner_Username(id, username).orElseThrow(ForbiddenException::new);

        final List<ContribuitionEntity> contribuitions = new ArrayList<>();

        project.getGoals().forEach(goal -> contribuitions.addAll(goal.getContribuitions()));

        BigDecimal sumAllContributions = contribuitions.stream()
                .map(ContribuitionEntity::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgMonth = sumAllContributions.divide(BigDecimal.valueOf(contribuitions.size()), BigDecimal.ROUND_HALF_DOWN);

        BigDecimal left = project.getGoals().stream().map(GoalEntity::getTarget).reduce(BigDecimal.ZERO, BigDecimal::add).subtract(sumAllContributions);

        left = left.max(BigDecimal.ZERO);

        BigDecimal months = left.divide(avgMonth, BigDecimal.ROUND_HALF_DOWN);

        return EstimatedConclusionDateResponse.builder()
                .average(sumAllContributions)
                .date(LocalDate.now().plusMonths(months.intValue()))
                .build();
    }

}

