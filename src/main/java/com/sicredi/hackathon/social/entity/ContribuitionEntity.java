package com.sicredi.hackathon.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contribuition")
public class ContribuitionEntity implements Serializable {

    private static final long serialVersionUID = -6209633616891908052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_contribuitor", nullable = false)
    private UserEntity contribuitor;

    @Column(nullable = false)
    private LocalDate date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_goal", nullable = false)
    private GoalEntity goal;

    @Column(nullable = false)
    private BigDecimal value;

    public ContribuitionEntity(final UserEntity contribuitor, final GoalEntity goal, final BigDecimal value) {
        this.contribuitor = contribuitor;
        this.goal = goal;
        this.value = value;
    }

    @PrePersist
    protected void onCreate() {
        date = LocalDate.now();
    }
}
