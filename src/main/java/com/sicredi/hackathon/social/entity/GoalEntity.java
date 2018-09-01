package com.sicredi.hackathon.social.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "goal")
@ToString
public class GoalEntity implements Serializable {

    private static final long serialVersionUID = -6209633616891908052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private BigDecimal target;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_project")
    private ProjectEntity project;

}
