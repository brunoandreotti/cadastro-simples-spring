package com.brunoandreotti.projeto_cadastro_spring.service.register;

import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserRequestDTO;

import com.brunoandreotti.projeto_cadastro_spring.entity.User;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;

public interface RegisterService {

    UserPF registerPF(UserRequestDTO userData);

    UserPJ registerPJ(UserRequestDTO userData);

}
