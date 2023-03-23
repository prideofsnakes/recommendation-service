package com.xmcyodc.recommendationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such crypto")
public class CryptoNotFoundException extends RuntimeException{
    public CryptoNotFoundException() {
        super("Please, try another crypto");
    }
}
