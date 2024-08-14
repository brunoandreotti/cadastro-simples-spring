package com.brunoandreotti.projeto_cadastro_spring.service.find;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import com.brunoandreotti.projeto_cadastro_spring.exception.UserNotFoundException;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPFRepository;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;
import com.brunoandreotti.projeto_cadastro_spring.util.StringConstants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindServiceImpl implements FindService {

    private final UserPFRepository userPFRepository;
    private final UserPJRepository userPJRepository;

    public FindServiceImpl(UserPFRepository userPFRepository, UserPJRepository userPJRepository) {
        this.userPFRepository = userPFRepository;
        this.userPJRepository = userPJRepository;
    }


    @Override
    public UserPF findPFById(Long id) {
        Optional<UserPF> user = userPFRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format(StringConstants.USER_NOT_FOUND, "ID", id));
        }

        return user.get();
    }

    @Override
    public UserPF findPFByDocument(String document) {
        Optional<UserPF> user = userPFRepository.findByCpf(document);

        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format(StringConstants.USER_NOT_FOUND, "CPF", document));
        }

        return user.get();
    }

    @Override
    public List<UserPF> findPFByName(String name) {
        return userPFRepository.findByNameContaining(name);
    }

    @Override
    public UserPJ findPJById(Long id) {
        Optional<UserPJ> user = userPJRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format(StringConstants.USER_NOT_FOUND, "ID", id));
        }

        return user.get();
    }

    @Override
    public UserPJ findPJByDocument(String document) {
        Optional<UserPJ> user = userPJRepository.findByCnpj(document);

        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format(StringConstants.USER_NOT_FOUND, "CNPJ", document));
        }

        return user.get();
    }

    @Override
    public List<UserPJ> findPJByName(String name) {
        return userPJRepository.findByNameContaining(name);
    }


}
