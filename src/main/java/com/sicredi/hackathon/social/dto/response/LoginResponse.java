package com.sicredi.hackathon.social.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -8401755475290391768L;

    private final String login;
}
