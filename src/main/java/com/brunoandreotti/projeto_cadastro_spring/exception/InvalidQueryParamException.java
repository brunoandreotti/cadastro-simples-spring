package com.brunoandreotti.projeto_cadastro_spring.exception;

public class InvalidQueryParamException extends RuntimeException {
    public InvalidQueryParamException(String message) {
        super(message);
    }
}
