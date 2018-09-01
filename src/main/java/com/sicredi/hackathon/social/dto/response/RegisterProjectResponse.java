package com.sicredi.hackathon.social.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class RegisterProjectResponse implements Serializable {

    private static final long serialVersionUID = -6517519991049595825L;

    private Long idProject;

}
