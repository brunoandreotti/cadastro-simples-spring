package com.brunoandreotti.projeto_cadastro_spring.service.find;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;

import java.util.List;

public interface FindService {

    UserPF findPFById(Long id);

    UserPF findPFByDocument(String document);

    List<UserPF> findPFByName(String name);

    UserPJ findPJById(Long id);

    UserPJ findPJByDocument(String document);

    List<UserPJ> findPJByName(String name);


}
