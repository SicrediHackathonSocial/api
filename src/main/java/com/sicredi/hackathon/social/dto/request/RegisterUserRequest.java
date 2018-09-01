package com.sicredi.hackathon.social.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RegisterUserRequest implements Serializable {

    private static final long serialVersionUID = -3747350943292946899L;

    private String username;

    private String password;

    private String picture;
}
