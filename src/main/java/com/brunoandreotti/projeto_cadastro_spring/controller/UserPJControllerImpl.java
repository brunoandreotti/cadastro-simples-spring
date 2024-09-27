package com.brunoandreotti.projeto_cadastro_spring.controller;

import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserRequestDTO;
import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserResponseDTO;
import com.brunoandreotti.projeto_cadastro_spring.service.delete.DeleteServiceImpl;
import com.brunoandreotti.projeto_cadastro_spring.service.find.FindService;
import com.brunoandreotti.projeto_cadastro_spring.service.list.ListService;
import com.brunoandreotti.projeto_cadastro_spring.service.register.RegisterService;
import jakarta.validation.Valid;
import org.hibernate.annotations.processing.Find;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/pj")
public class UserPJControllerImpl implements UserPJController {

    private final RegisterService registerService;
    private final ListService listService;
    private final FindService findService;
    private final DeleteServiceImpl deleteService;

    public UserPJControllerImpl(RegisterService registerService, ListService listService, FindService findService, DeleteServiceImpl deleteService) {
        this.registerService = registerService;
        this.listService = listService;
        this.findService = findService;
        this.deleteService = deleteService;
    }

    @PostMapping
    @Override
    public ResponseEntity<UserResponseDTO> registerPJ(@Valid @RequestBody UserRequestDTO userData) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserResponseDTO.fromUserPJ(registerService.registerPJ(userData)));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserResponseDTO>> listPJ(@RequestParam("type") String type, @RequestParam("order") String order) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listService.listPJ(type, order).stream().map(UserResponseDTO::fromUserPJ).toList());
    }

    @Override
    @GetMapping("/document/{document}")
    public ResponseEntity<UserResponseDTO> findPJByDocument(@PathVariable String document) {
        return ResponseEntity.status(HttpStatus.OK).body(UserResponseDTO.fromUserPJ(findService.findPJByDocument(document)));
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDTO> findPJById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(UserResponseDTO.fromUserPJ(findService.findPJById(id)));
    }

    @Override
    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserResponseDTO>> findPJByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findService.findPJByName(name).stream().map(UserResponseDTO::fromUserPJ).toList());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePJById(@PathVariable Long id) {
        deleteService.deletePJ(id);
        return ResponseEntity.status(200).build();
    }
}
