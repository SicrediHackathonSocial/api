package com.sicredi.hackathon.social.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class RegisterGoalsRequest implements Serializable {


    private Long idProject;
    private List<RegisterGoalRequest> goals;

}
