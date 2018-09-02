package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.domain.GoalStatus;
import com.sicredi.hackathon.social.domain.ProjectStatus;
import com.sicredi.hackathon.social.dto.request.AddValueGoalRequest;
import com.sicredi.hackathon.social.dto.request.EditGoalRequest;
import com.sicredi.hackathon.social.dto.request.RegisterGoalRequest;
import com.sicredi.hackathon.social.dto.request.RegisterGoalsRequest;
import com.sicredi.hackathon.social.dto.response.AddValueGoalResponse;
import com.sicredi.hackathon.social.entity.ContribuitionEntity;
import com.sicredi.hackathon.social.entity.GoalEntity;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.repository.ContribuitionRepository;
import com.sicredi.hackathon.social.repository.GoalRepository;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.sicredi.hackathon.social.domain.GoalStatus.EM_ANDAMENTO;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ContribuitionRepository contribuitionRepository;

    @Autowired
    private UserService userService;

    public ResponseEntity register(final String username, final RegisterGoalsRequest request) {

        ProjectEntity projectEntity = projectService.find(request.getIdProject());

        List<GoalEntity> goals = request.getGoals().stream()
                .map(requestGoal -> buildGoalEntity(requestGoal, projectEntity))
                .collect(Collectors.toList());


        goalRepository.saveAll(goals);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private GoalEntity buildGoalEntity(RegisterGoalRequest request, ProjectEntity projectEntity) {
        return GoalEntity.builder()
                .project(projectEntity)
                .title(request.getTitle())
                .target(request.getTarget())
                .status(EM_ANDAMENTO)
                .build();
    }

    public ResponseEntity edit(final String username, final EditGoalRequest request) {
        ProjectEntity projectEntity = projectService.find(request.getIdProject());

        GoalEntity goalEntity = GoalEntity.builder()
                .id(request.getId())
                .project(projectEntity)
                .title(request.getTitle())
                .target(request.getTarget())
                .build();

        goalRepository.save(goalEntity);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public GoalEntity find(final String username, final Long id) {

        return goalRepository.findById(id).orElseThrow(NotFoundException::new);

    }

    public GoalEntity delete(String username, Long id) {
        GoalEntity goalEntity = goalRepository.findById(id).orElseThrow(NotFoundException::new);
        goalRepository.delete(goalEntity);
        return goalEntity;
    }

    public AddValueGoalResponse addValue(final String username, final AddValueGoalRequest request) {

        UserEntity userEntity = userService.findUserByUsername(username);
        GoalEntity goalEntity = goalRepository.findById(request.getIdGoal()).orElseThrow(NotFoundException::new);
        ProjectEntity project = goalEntity.getProject();

        ContribuitionEntity contribuitionEntity = ContribuitionEntity.builder()
                .contribuitor(userEntity)
                .goal(goalEntity)
                .value(request.getValue())
                .build();

        contribuitionRepository.save(contribuitionEntity);

        List<ContribuitionEntity> contribuitions = goalEntity.getContribuitions();

        BigDecimal reached = contribuitions.stream()
                .map(ContribuitionEntity::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (reached.compareTo(goalEntity.getTarget()) >= 0) {
            goalEntity.setStatus(GoalStatus.CONCLUIDO);
            goalRepository.save(goalEntity);

            if (project.getGoals().stream().allMatch(goal -> goal.getStatus().equals(GoalStatus.CONCLUIDO))) {
                project.setStatus(ProjectStatus.CONCLUIDO);
                projectRepository.save(project);
            }
        }

        return AddValueGoalResponse.builder()
                .projectStatus(project.getStatus())
                .goalStatus(goalEntity.getStatus())
                .build();
    }

    @Transactional
    public void createContribuition(final String username, final Long idGoal, final BigDecimal value) {

        UserEntity userEntity = userService.findUserByUsername(username);
        GoalEntity goalEntity = goalRepository.findById(idGoal).orElseThrow(NotFoundException::new);

        ContribuitionEntity contribuitionEntity = ContribuitionEntity.builder()
                .contribuitor(userEntity)
                .goal(goalEntity)
                .value(value)
                .build();

        contribuitionRepository.save(contribuitionEntity);

    }
}
