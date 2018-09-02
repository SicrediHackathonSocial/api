package com.sicredi.hackathon.social.controller;

import com.sicredi.hackathon.social.dto.request.LoginRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.LoginResponse;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserRequest request) {
        userService.insert(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{username}")
    public UserEntity findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @GetMapping("/projects")
    public List<ProjectEntity> findProjectsByUserLogged(@RequestHeader("Authorization") String username) {
        return userService.findProjectsByUserLogged(username);
    }

    @GetMapping("/projects/public/{username}")
    public List<ProjectEntity> findProjectsPublicByUsername(@PathVariable String username) {
        return userService.findProjectsPublicByUsername(username);
    }

    @GetMapping("/projects/shared")
    public List<ProjectEntity> findProjectsSharedWithMe(@RequestHeader("Authorization") String username) {
        return userService.findProjectsSharedWithMe(username);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody final LoginRequest request){
        return userService.login(request);
    }

    @GetMapping("/followers")
    public List<UserEntity> findFollowersByUserLogged(@RequestHeader("Authorization") String username) {
        return userService.findFollowersByUserLogged(username);
    }

    @GetMapping("/following")
    public List<UserEntity> findFollowingByUserLogged(@RequestHeader("Authorization") String username) {
        return userService.findFollowingByUserLogged(username);
    }

}
