package com.brunoandreotti.projeto_cadastro_spring.controller;

import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserRequestDTO;
import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserPFController {

    ResponseEntity<UserResponseDTO> registerPF(UserRequestDTO userData);


    ResponseEntity<List<UserResponseDTO>> listPF(String type, String order);


    ResponseEntity<UserResponseDTO> findPFByDocument(String document);

    ResponseEntity<UserResponseDTO> findPFById(Long id);

    ResponseEntity<List<UserResponseDTO>> findPFByName(String name);

    ResponseEntity<Void> deletePFById(Long id);
}
