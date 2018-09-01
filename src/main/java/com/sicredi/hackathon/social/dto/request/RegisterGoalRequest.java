package com.sicredi.hackathon.social.dto.request;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class RegisterGoalRequest implements Serializable {

    private static final long serialVersionUID = 9122563379461214978L;

    private Long idProject;
    private String title;
    private BigDecimal target;

}
