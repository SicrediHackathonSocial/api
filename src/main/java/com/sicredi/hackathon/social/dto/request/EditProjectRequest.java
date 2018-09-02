package com.sicredi.hackathon.social.dto.request;

import com.sicredi.hackathon.social.domain.ProjectType;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditProjectRequest implements Serializable {

    private static final long serialVersionUID = -1982409998890677958L;

    private Long id;
    private String title;
    private String description;
    private ProjectType type;
}
