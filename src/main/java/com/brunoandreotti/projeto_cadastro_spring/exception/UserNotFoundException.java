package com.brunoandreotti.projeto_cadastro_spring.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
