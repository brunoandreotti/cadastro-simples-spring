package com.brunoandreotti.projeto_cadastro_spring.service.register;

import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserRequestDTO;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import com.brunoandreotti.projeto_cadastro_spring.exception.InvalidDocumentException;
import com.brunoandreotti.projeto_cadastro_spring.exception.UserAlreadyExistsException;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPFRepository;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;
import com.brunoandreotti.projeto_cadastro_spring.util.CheckDocumentFormat;
import com.brunoandreotti.projeto_cadastro_spring.util.StringConstants;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserPFRepository userPFRepository;
    private final UserPJRepository userPJRepository;


    public RegisterServiceImpl(UserPFRepository userPFRepository, UserPJRepository userPJRepository) {
        this.userPFRepository = userPFRepository;
        this.userPJRepository = userPJRepository;
    }


    @Override
    public UserPF registerPF(UserRequestDTO userData) {

        if (CheckDocumentFormat.check(userData.document(), 11)) {
            throw new InvalidDocumentException(StringConstants.INVALID_PF_DOC);
        }

        Optional<UserPF> user = userPFRepository.findByCpf(userData.document());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException(StringConstants.USER_EXISTS_ERROR);
        }

        UserPF newUser = userData.toUserPF();

        newUser = userPFRepository.save(newUser);

        return newUser;

    }

    @Override
    public UserPJ registerPJ(UserRequestDTO userData) {

        if (CheckDocumentFormat.check(userData.document(), 12)) {
            throw new InvalidDocumentException(StringConstants.INVALID_PJ_DOC);
        }

        Optional<UserPJ> user = userPJRepository.findByCnpj(userData.document());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException(StringConstants.USER_EXISTS_ERROR);
        }

        UserPJ newUser = userData.toUserPJ();

        newUser = userPJRepository.save(newUser);

        return newUser;
    }
}
