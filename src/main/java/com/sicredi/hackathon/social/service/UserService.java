package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.dto.request.LoginRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.LoginResponse;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.AttemptLoginException;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import com.sicredi.hackathon.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void insert(final RegisterUserRequest user) {

        final UserEntity userEntity = UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .picture(user.getPicture())
                .build();

        userRepository.save(userEntity);
    }

    public UserEntity findUserByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public List<ProjectEntity> findProjectsByUserLogged(final String username) {
        return projectRepository.findAllByOwner_Username(username);
    }

    public List<ProjectEntity> findProjectsPublicByUsername(final String username) {
        return projectRepository.findProjectsPublicByUsername(username);
    }

    public List<ProjectEntity> findProjectsSharedWithMe(final String username) {
        final UserEntity user = findUserByUsername(username);
        return projectRepository.findAllByOwnerIsNotAndContribuitorsContains(user, user);
    }

    public LoginResponse login(final LoginRequest request) {
        UserEntity user = userRepository.findByUsernameAndAndPassword(request.getUsername(), request.getPassword()).orElseThrow(AttemptLoginException::new);

        return LoginResponse.builder()
                .login(request.getUsername())
                .build();

    public List<UserEntity> findFollowersByUserLogged(final String username) {
        final UserEntity user = findUserByUsername(username);
        return userRepository.findByFollowingContains(user);
    }

    public List<UserEntity> findFollowingByUserLogged(final String username) {
        final UserEntity user = findUserByUsername(username);
        return userRepository.findByFollowersContains(user);
    }
}
