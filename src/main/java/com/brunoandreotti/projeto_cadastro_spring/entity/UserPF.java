package com.brunoandreotti.projeto_cadastro_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_USER_PF")
public class UserPF extends User {

    @Column(nullable = false, unique = true)
    String cpf;

    public UserPF(Long id, String name, LocalDate birthDate, String cpf)  {
        super(id, name, birthDate);
        this.cpf = cpf;
    }
}
