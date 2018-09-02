package com.sicredi.hackathon.social.dto.request;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class AddValueGoalRequest implements Serializable {

    private static final long serialVersionUID = -8731697137916126975L;

    private Long idGoal;
    private BigDecimal value;

}