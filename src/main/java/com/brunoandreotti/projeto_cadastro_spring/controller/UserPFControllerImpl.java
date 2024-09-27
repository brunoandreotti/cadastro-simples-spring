package com.brunoandreotti.projeto_cadastro_spring.controller;

import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserRequestDTO;
import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserResponseDTO;
import com.brunoandreotti.projeto_cadastro_spring.service.delete.DeleteServiceImpl;
import com.brunoandreotti.projeto_cadastro_spring.service.find.FindService;
import com.brunoandreotti.projeto_cadastro_spring.service.list.ListService;
import com.brunoandreotti.projeto_cadastro_spring.service.register.RegisterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/pf")
public class UserPFControllerImpl implements UserPFController {

    private final RegisterService registerService;
    private final ListService listService;
    private final FindService findService;
    private final DeleteServiceImpl deleteService;

    public UserPFControllerImpl(RegisterService registerService, ListService listService, FindService findService, DeleteServiceImpl deleteService) {
        this.registerService = registerService;
        this.listService = listService;
        this.findService = findService;
        this.deleteService = deleteService;
    }

    @Override
    @PostMapping()
    public ResponseEntity<UserResponseDTO> registerPF(@Valid @RequestBody UserRequestDTO userData) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserResponseDTO.fromUserPF(registerService.registerPF(userData)));    }


    @Override
    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> listPF(@RequestParam("type") String type, @RequestParam("order") String order) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listService.listPF(type, order).stream().map(UserResponseDTO::fromUserPF).toList());
    }

    @Override
    @GetMapping("/document/{document}")
    public ResponseEntity<UserResponseDTO> findPFByDocument(@PathVariable String document) {
        return ResponseEntity.status(HttpStatus.OK).body(UserResponseDTO.fromUserPF(findService.findPFByDocument(document)));
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDTO> findPFById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(UserResponseDTO.fromUserPF(findService.findPFById(id)));
    }

    @Override
    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserResponseDTO>> findPFByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findService.findPFByName(name).stream().map(UserResponseDTO::fromUserPF).toList());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePFById(@PathVariable Long id) {
        deleteService.deletePJ(id);
        return ResponseEntity.status(200).build();
    }


}
