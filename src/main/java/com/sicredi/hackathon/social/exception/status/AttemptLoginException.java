package com.sicredi.hackathon.social.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AttemptLoginException extends RuntimeException{
    private static final long serialVersionUID = -5714909738581100052L;
}
