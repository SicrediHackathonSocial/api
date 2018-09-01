package com.sicredi.hackathon.social.entity;

import com.sicredi.hackathon.social.domain.ProjectType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goal")
@ToString
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

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    private ProjectEntity project;

    public GoalEntity(final String title, final BigDecimal target, final ProjectEntity project) {
        this.title = title;
        this.target = target;
        this.project = project;
    }
}
