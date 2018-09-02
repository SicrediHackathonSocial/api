package com.sicredi.hackathon.social.entity;

import com.sicredi.hackathon.social.domain.ProjectStatus;
import com.sicredi.hackathon.social.domain.ProjectType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sicredi.hackathon.social.domain.ProjectStatus.EM_ANDAMENTO;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
@ToString
public class ProjectEntity implements Serializable {

    private static final long serialVersionUID = -7688722208070330673L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private LocalDate created;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ProjectType type;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    @ManyToOne
    @JoinColumn(name = "id_owner", nullable = false)
    private UserEntity owner;

    @ManyToMany
    @JoinTable(name = "project_contribuitors",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_contribuitor"))
    private List<UserEntity> contribuitors;

    @OneToMany(mappedBy = "project")
    private List<GoalEntity> goals;

    public ProjectEntity(final String title, final String description, final UserEntity owner, final ProjectType type) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.type = type;
        this.status = EM_ANDAMENTO;
    }

    public ProjectEntity(final String title, final String description, final UserEntity owner, final ProjectType type, final List<UserEntity> contribuitors) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.type = type;
        this.contribuitors = contribuitors;
        this.status = EM_ANDAMENTO;
    }

    @PrePersist
    protected void onCreate() {
        created = LocalDate.now();
    }
}
