package com.brunoandreotti.projeto_cadastro_spring.repository;


import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPFRepository extends JpaRepository<UserPF, Long> {

    Optional<UserPF> findByCpf(String document);

    List<UserPF> findByNameContaining(String name);

    List<UserPF> findAllByOrderByNameAsc();

    List<UserPF> findAllByOrderByNameDesc();

    List<UserPF> findAllByOrderByBirthDateDesc();

    List<UserPF> findAllByOrderByBirthDateAsc();
}
