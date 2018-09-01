package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.dto.request.AddValueGoalRequest;
import com.sicredi.hackathon.social.dto.request.EditGoalRequest;
import com.sicredi.hackathon.social.dto.request.RegisterGoalRequest;
import com.sicredi.hackathon.social.dto.response.RegisterGoalResponse;
import com.sicredi.hackathon.social.entity.ContribuitionEntity;
import com.sicredi.hackathon.social.entity.GoalEntity;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.repository.ContribuitionRepository;
import com.sicredi.hackathon.social.repository.GoalRepository;
import com.sicredi.hackathon.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ContribuitionRepository contribuitionRepository;

    @Autowired
    private UserService userService;

    public RegisterGoalResponse register(final String username, final RegisterGoalRequest request) {

        ProjectEntity projectEntity = projectService.find(username, request.getIdProject());

        GoalEntity goalEntity = GoalEntity.builder()
                .project(projectEntity)
                .title(request.getTitle())
                .target(request.getTarget())
                .build();

        goalEntity = goalRepository.save(goalEntity);

        return RegisterGoalResponse.builder()
                .id(goalEntity.getId())
                .build();

    }

    public ResponseEntity edit(final String username, final EditGoalRequest request) {
        ProjectEntity projectEntity = projectService.find(username, request.getIdProject());

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

    public ResponseEntity addValue(final String username, final AddValueGoalRequest request) {

        UserEntity userEntity = userService.findUserByUsername(username);
        GoalEntity goalEntity = goalRepository.findById(request.getIdGoal()).orElseThrow(NotFoundException::new);

        ContribuitionEntity contribuitionEntity = ContribuitionEntity.builder()
                .contribuitor(userEntity)
                .goal(goalEntity)
                .value(request.getValue())
                .build();

        contribuitionRepository.save(contribuitionEntity);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
