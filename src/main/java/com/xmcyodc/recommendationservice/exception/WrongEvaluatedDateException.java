package com.xmcyodc.recommendationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No results for such day")
public class WrongEvaluatedDateException extends RuntimeException{

    public WrongEvaluatedDateException() {
        super("Please try another date");
    }
}
