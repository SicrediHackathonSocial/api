package com.sicredi.hackathon.social.controller;


import com.sicredi.hackathon.social.dto.request.*;
import com.sicredi.hackathon.social.dto.response.RegisterGoalResponse;
import com.sicredi.hackathon.social.dto.response.RegisterProjectResponse;
import com.sicredi.hackathon.social.entity.GoalEntity;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/project")
public class ProjectController {

    @PostMapping
    public RegisterProjectResponse registerProject(RegisterProjectRequest request) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity editProject(String id, EditProjectRequest request) {
        return null;
    }

    @GetMapping("/{id}")
    public ProjectEntity findProject(Integer id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ProjectEntity deleteProject(Integer id) {
        return null;
    }

    @PostMapping("/{idProject}/goal")
    public RegisterGoalResponse registerGoal(Integer idProject, RegisterGoalRequest request) {
        return null;
    }

    @PutMapping("/{idProject}/goal/{id}")
    public ResponseEntity editGoal(Integer idProject, EditGoalRequest request) {
        return null;
    }

    @GetMapping("/{idProject}/goal/{id}")
    public GoalEntity findGoal(Integer idProject, Integer idGoal) {
        return null;
    }

    @DeleteMapping("/{idProject}/goal/{id}")
    public GoalEntity deleteGoal(Integer idProject, Integer idGoal) {
        return null;
    }

    @PutMapping("/{idProject}/goal/{id}/value")
    public ResponseEntity addValue(Integer idProject, Integer idGoal, AddValueGoalRequest request) {
        return null;
    }


}
