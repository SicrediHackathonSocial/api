package com.sicredi.hackathon.social.repository;


import com.sicredi.hackathon.social.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(final String username);

    Optional<UserEntity> findByUsernameAndAndPassword(final String username, final String password);
    
    List<UserEntity> findByFollowingContains(UserEntity user);

    List<UserEntity> findByFollowersContains(UserEntity user);

    List<UserEntity> findByUsernameIgnoreCaseLike(String username);

}
