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
@Table(name = "contribuition")
@ToString
public class ContribuitionEntity implements Serializable {

    private static final long serialVersionUID = -6209633616891908052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @Column(name = "id_contribuitor", nullable = false)
    private UserEntity contribuitor;

    @OneToOne
    @Column(name = "id_goal", nullable = false)
    private GoalEntity goal;

    @Column(nullable = false)
    private BigDecimal target;

}
