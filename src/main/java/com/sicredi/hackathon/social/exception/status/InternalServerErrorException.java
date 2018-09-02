package com.sicredi.hackathon.social.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException{
    private static final long serialVersionUID = -8966518297246959573L;
}
