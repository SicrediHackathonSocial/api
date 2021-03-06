package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.domain.ProjectType;
import com.sicredi.hackathon.social.dto.request.LoginRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.LoginResponse;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.AttemptLoginException;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import com.sicredi.hackathon.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.BooleanUtils.isFalse;

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
        return userRepository.findByUsername(username).orElseThrow(NotFoundException::new);
    }

    public List<ProjectEntity> findProjectsByUserLogged(final String username) {
        return projectRepository.findAllByOwner_Username(username);
    }

    public List<ProjectEntity> findProjectsPublicByUsername(final String username) {
        return projectRepository.findAllByOwner_UsernameAndType(username, ProjectType.PUBLIC);
    }

    public List<ProjectEntity> findProjectsSharedWithMe(final String username) {
        final UserEntity user = findUserByUsername(username);
        return projectRepository.findAllByOwnerAndTypeOrContribuitorsContains(user, ProjectType.SHARED, user);
    }

    public LoginResponse login(final LoginRequest request) {

        Optional<UserEntity> user = userRepository.findByUsername(request.getUsername());

        if(isFalse(user.isPresent())){
            UserEntity newUser = UserEntity.builder()
                    .username(request.getUsername())
                    .password("naotem")
                    .build();

            userRepository.save(newUser);
        }

        return LoginResponse.builder()
                .login(request.getUsername())
                .build();
    }

    public List<UserEntity> findFollowersByUserLogged(final String username) {
        final UserEntity user = findUserByUsername(username);
        return userRepository.findByFollowingContains(user);
    }

    public List<UserEntity> findFollowingByUserLogged(final String username) {
        final UserEntity user = findUserByUsername(username);
        return userRepository.findByFollowersContains(user);
    }

    public List<UserEntity> findByUsernameLike(final String username) {
        return userRepository.findByUsernameIgnoreCaseLike(username);
    }

}
