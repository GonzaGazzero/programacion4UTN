package com.club.sociosclub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DniDuplicadoException.class)
    public ResponseEntity<String> handleDniDuplicadoException(DniDuplicadoException ex) {
        return new ResponseEntity<>("El DNI ingresado ya se encuentra registrado en el sistema.", HttpStatus.CONFLICT);
    }
}
