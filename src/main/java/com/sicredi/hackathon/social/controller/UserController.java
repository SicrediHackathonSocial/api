package com.sicredi.hackathon.social.controller;

import com.sicredi.hackathon.social.dto.request.EditUserRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.RegisterUserResponse;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity editUser(String id, EditUserRequest request) {
        return null;
    }

    @GetMapping("/{id}")
    public UserEntity findUser(Integer id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public UserEntity deleteUser(Integer id) {
        return null;
    }

    @GetMapping("/{idUser}/projects")
    public List<ProjectEntity> findUserProjects(Integer id) {
        return null;
    }


}
