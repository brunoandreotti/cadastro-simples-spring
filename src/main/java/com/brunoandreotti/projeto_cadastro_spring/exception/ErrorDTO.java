package com.brunoandreotti.projeto_cadastro_spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDTO {

    String errorMessage;
}