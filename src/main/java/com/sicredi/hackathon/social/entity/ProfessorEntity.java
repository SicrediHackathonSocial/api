package com.sicredi.hackathon.social.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "professor")
@ToString //se tiver CPF ou alguma informação privada, deve estar no exclude
//TODO rever dados necessários
public class ProfessorEntity implements Serializable {

    private static final long serialVersionUID = -6209633616891908052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idProfessor;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 10)
    private String matricula;

}
