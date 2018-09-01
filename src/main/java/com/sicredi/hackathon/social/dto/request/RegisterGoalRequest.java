package com.sicredi.hackathon.social.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class RegisterGoalRequest implements Serializable {

    private static final long serialVersionUID = -7270994979962436515L;

    private String title;
    private BigDecimal target;

}
