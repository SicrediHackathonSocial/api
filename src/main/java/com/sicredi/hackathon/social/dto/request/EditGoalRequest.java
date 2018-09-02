package com.sicredi.hackathon.social.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditGoalRequest implements Serializable {

    private static final long serialVersionUID = -1102002521617938531L;

    private Long id;
    private Long idProject;
    private String title;
    private BigDecimal target;


}
