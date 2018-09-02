package com.sicredi.hackathon.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sicredi.hackathon.social.domain.GoalStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goal")
public class GoalEntity implements Serializable {


    private static final long serialVersionUID = -6207389170048991762L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private BigDecimal target;

    @Transient
    private BigDecimal reached = BigDecimal.ZERO;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    private ProjectEntity project;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private GoalStatus status;

    @OneToMany(mappedBy = "goal")
    private List<ContribuitionEntity> contribuitions;

    public GoalEntity(final String title, final BigDecimal target, final ProjectEntity project) {
        this.title = title;
        this.target = target;
        this.project = project;
        this.status = GoalStatus.EM_ANDAMENTO;
    }
}
