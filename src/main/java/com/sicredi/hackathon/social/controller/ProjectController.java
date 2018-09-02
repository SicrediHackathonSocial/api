package com.sicredi.hackathon.social.controller;


import com.sicredi.hackathon.social.dto.request.EditProjectRequest;
import com.sicredi.hackathon.social.dto.request.RegisterProjectRequest;
import com.sicredi.hackathon.social.dto.response.RegisterProjectResponse;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public RegisterProjectResponse registerProject(@RequestHeader(value = "Authorization", required = false) final String username, @RequestBody final RegisterProjectRequest request) {
        return projectService.register(username, request);
    }

    @PostMapping("/membership/{project}")
    public void addMember(@RequestHeader("Authorization") final String user,
                          @PathVariable("project") final Long idProject) {
        projectService.addMembership(user, idProject);
    }

    @PutMapping
    public ResponseEntity editProject(@RequestHeader(value = "Authorization", required = false) final String username, @RequestBody final EditProjectRequest request) {
        return projectService.edit(username, request);
    }

    @GetMapping("/{id}")
    public ProjectEntity findProject(@PathVariable("id") final Long id) {
        return projectService.find(id);
    }

    @DeleteMapping("/{id}")
    public ProjectEntity deleteProject(@RequestHeader(value = "Authorization", required = false) final String username, @PathVariable("id") final Long id) {
        return projectService.delete(username, id);
    }

    @GetMapping("/public/random")
    public ProjectEntity findOnePublicProject(@RequestHeader("Authorization") final String username) {
        return projectService.findOnePublicProject(username);
    }

    @GetMapping("/public")
    public List<ProjectEntity> findPublicProjects() {
        return projectService.findAllPublic();
    }

}
