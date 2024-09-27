package com.brunoandreotti.projeto_cadastro_spring.service.delete;

import com.brunoandreotti.projeto_cadastro_spring.repository.UserPFRepository;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceImpl {

    private final UserPFRepository userPFRepository;
    private final UserPJRepository userPJRepository;


    public DeleteServiceImpl(UserPFRepository userPFRepository, UserPJRepository userPJRepository) {
        this.userPFRepository = userPFRepository;
        this.userPJRepository = userPJRepository;
    }

    public void deletePJ(Long id) {
        if (id != null) {
            if (userPJRepository.existsById(id)) {
                userPJRepository.deleteById(id);
            }
        }
    }

    public void deletePF(Long id) {
        userPFRepository.deleteById(id);
    }
}
