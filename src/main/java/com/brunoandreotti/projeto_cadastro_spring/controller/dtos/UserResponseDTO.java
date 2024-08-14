package com.brunoandreotti.projeto_cadastro_spring.controller.dtos;

import com.brunoandreotti.projeto_cadastro_spring.entity.User;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;

import java.time.LocalDate;

public record UserResponseDTO(Long id,
                              String name,
                              String document,
                              LocalDate birthDate) {

    static public UserResponseDTO fromUserPF(UserPF user) {

        return new UserResponseDTO(user.getId(), user.getName(), user.getCpf(), user.getBirthDate());
    }

    static public UserResponseDTO fromUserPJ(UserPJ user) {

        return new UserResponseDTO(user.getId(), user.getName(), user.getCnpj(), user.getBirthDate());
    }
}
