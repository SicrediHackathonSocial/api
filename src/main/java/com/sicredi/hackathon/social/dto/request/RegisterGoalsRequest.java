package com.sicredi.hackathon.social.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterGoalsRequest implements Serializable {


    private Long idProject;
    private List<RegisterGoalRequest> goals;

}
