package com.brunoandreotti.projeto_cadastro_spring.controller;

import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserRequestDTO;
import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserPJController {
    ResponseEntity<UserResponseDTO> registerPJ(UserRequestDTO userData);

    ResponseEntity<List<UserResponseDTO>> listPJ(String type, String order);

    ResponseEntity<UserResponseDTO> findPJByDocument(String document);

    ResponseEntity<UserResponseDTO> findPJById(Long id);

    ResponseEntity<List<UserResponseDTO>> findPJByName(String name);
}
