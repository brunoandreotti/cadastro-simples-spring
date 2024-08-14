package com.brunoandreotti.projeto_cadastro_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.Objects;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        String erros = Objects.requireNonNull(ex.getFieldError()).getDefaultMessage();
        
        ErrorDTO errorResponse = new ErrorDTO(erros);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = InvalidDocumentException.class)
    public ResponseEntity<ErrorDTO> handleInvalidDocumentException(InvalidDocumentException ex) {

        ErrorDTO errorResponse = new ErrorDTO(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = InvalidQueryParamException.class)
    public ResponseEntity<ErrorDTO> handleIQueryParamsException(InvalidQueryParamException ex) {

        ErrorDTO errorResponse = new ErrorDTO(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleIUserAlreadyExistsException(UserAlreadyExistsException ex) {

        ErrorDTO errorResponse = new ErrorDTO(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleIUserNotFoundException(UserNotFoundException ex) {

        ErrorDTO errorResponse = new ErrorDTO(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        ErrorDTO errorResponse = new ErrorDTO(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
