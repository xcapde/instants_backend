package com.xevicorp1.instants.controllers;

import com.xevicorp1.instants.dto.ErrorDto;
import com.xevicorp1.instants.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExHandler(RuntimeException ex){
        var error = ErrorDto.builder()
                .code("P-558")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDto> NotFoundExHandler(NotFoundException ex){
        var error = ErrorDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
