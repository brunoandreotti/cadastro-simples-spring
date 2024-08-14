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
@Table(name = "TB_USER_PJ")
public class UserPJ extends User {

    @Column(nullable = false, unique = true)
    String cnpj;

    public UserPJ(Long id, String name, LocalDate birthDate, String cnpj)  {
        super(id, name, birthDate);
        this.cnpj = cnpj;
    }
}
