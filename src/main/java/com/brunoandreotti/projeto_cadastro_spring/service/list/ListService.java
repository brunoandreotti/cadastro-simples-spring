package com.brunoandreotti.projeto_cadastro_spring.service.list;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;

import java.util.List;

public interface ListService {

    List<UserPF> listPF(String type, String order);

    List<UserPJ> listPJ(String type, String order);

    List<UserPF> listPFByNameAsc();

    List<UserPF> listPFByNameDesc();

    List<UserPJ> listPJByNameAsc();

    List<UserPJ> listPJByNameDesc();

    List<UserPF> listPFByAgeAsc();

    List<UserPF> listPFByAgeDesc();

    List<UserPJ> listPJByAgeAsc();

    List<UserPJ> listPJByAgeDesc();
}
