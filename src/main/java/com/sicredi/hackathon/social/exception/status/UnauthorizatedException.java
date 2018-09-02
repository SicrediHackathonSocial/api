package com.sicredi.hackathon.social.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizatedException extends RuntimeException {
    private static final long serialVersionUID = 2936681776456367832L;
}
