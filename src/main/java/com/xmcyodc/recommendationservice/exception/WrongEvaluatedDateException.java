package com.xmcyodc.recommendationservice.exception;

public class WrongEvaluatedDateException extends RuntimeException{

    public WrongEvaluatedDateException() {
        super("Your date is out of range. Please try another date");
    }
}
