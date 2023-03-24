package com.xmcyodc.recommendationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    public static final String TIMESTAMP_FIELD = "timestamp";
    public static final String MESSAGE_FIELD = "message";

    @ExceptionHandler(CryptoNotFoundException.class)
    public ResponseEntity<Object> handleCryptoNotFoundException(CryptoNotFoundException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP_FIELD, LocalDateTime.now());
        body.put(MESSAGE_FIELD, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongEvaluatedDateException.class)
    public ResponseEntity<Object> handleWrongDateException(WrongEvaluatedDateException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP_FIELD, LocalDateTime.now());
        body.put(MESSAGE_FIELD, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(CsvParserException.class)
    public ResponseEntity<Object> handleParserException(CsvParserException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP_FIELD, LocalDateTime.now());
        body.put(MESSAGE_FIELD, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
