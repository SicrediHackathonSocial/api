package com.sicredi.hackathon.social.dto.response;

import com.sicredi.hackathon.social.domain.GoalStatus;
import com.sicredi.hackathon.social.domain.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddValueGoalResponse {

    private ProjectStatus projectStatus;

    private GoalStatus goalStatus;

}
