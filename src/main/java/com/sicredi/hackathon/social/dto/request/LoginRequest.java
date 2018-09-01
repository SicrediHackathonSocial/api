package com.sicredi.hackathon.social.dto.request;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = -9176057978812918507L;
    
    private String username;
    private String password;

}
