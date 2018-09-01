package com.sicredi.hackathon.social.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class RegisterGoalResponse implements Serializable {

    private static final long serialVersionUID = 3512424208871584558L;

    private Long id;

}
