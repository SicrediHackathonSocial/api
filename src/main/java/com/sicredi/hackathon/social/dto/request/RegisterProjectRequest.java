package com.sicredi.hackathon.social.dto.request;

import com.sicredi.hackathon.social.domain.ProjectType;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
public class RegisterProjectRequest implements Serializable {

    private static final long serialVersionUID = -5285321423835750466L;

    private String title;
    private String description;
    private ProjectType type;

}
