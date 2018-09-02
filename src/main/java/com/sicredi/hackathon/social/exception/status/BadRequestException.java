package com.sicredi.hackathon.social.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 2714301490144645526L;
}
