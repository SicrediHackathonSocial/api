package com.sicredi.hackathon.social.entity;

import com.sicredi.hackathon.social.domain.ProjectType;
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
@Table(name = "project")
@ToString
public class ProjectEntity implements Serializable {

    private static final long serialVersionUID = -6209633616891908052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ProjectType type;

    @OneToOne
    @JoinColumn(name = "id_project", nullable = false)
    private UserEntity owner;

    @JoinColumn(name = "id_project")
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserEntity> contributors;

}
