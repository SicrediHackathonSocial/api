package com.sicredi.hackathon.social.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
@ToString
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -6209633616891908052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 30)
    private String password;

    @ManyToMany(mappedBy = "contribuitors")
    private List<ProjectEntity> projects;

    public UserEntity(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
}
