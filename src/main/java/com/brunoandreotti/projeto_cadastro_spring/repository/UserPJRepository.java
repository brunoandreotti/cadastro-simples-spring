package com.brunoandreotti.projeto_cadastro_spring.repository;


import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPJRepository extends JpaRepository<UserPJ, Long> {

    Optional<UserPJ> findByCnpj(String document);

    List<UserPJ> findByNameContaining(String name);

    List<UserPJ> findAllByOrderByNameAsc();

    List<UserPJ> findAllByOrderByNameDesc();

    List<UserPJ> findAllByOrderByBirthDateDesc();

    List<UserPJ> findAllByOrderByBirthDateAsc();
}
