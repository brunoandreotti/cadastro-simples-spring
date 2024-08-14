package com.brunoandreotti.projeto_cadastro_spring.controller.dtos;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import com.brunoandreotti.projeto_cadastro_spring.util.ConvertStringToDate;
import com.brunoandreotti.projeto_cadastro_spring.util.StringConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(@NotBlank(message = "Nome não pode ser vazio") String name,
                             @NotBlank(message = "Data de nascimento não pode ser vazia")
                             @Pattern(regexp = StringConstants.DATE_REGEX, message = "Data de nascimento deve ser no formato dd/mm/aaaa")
                             String birthDate,
                             @NotBlank(message = "Document não pode ser vazio")
                             @Size(min = 11, max = 12, message = "Documento deve conter 11 ou 12 dígitos")
                             @Pattern(regexp = StringConstants.DOCUMENT_FORMAT_REGEX, message = "Documento deve ser uma string somente com números")
                             String document) {



    public UserPF toUserPF() {
        UserPF user = new UserPF();

        user.setCpf(this.document);
        user.setName(this.name);
        user.setBirthDate(ConvertStringToDate.convert(this.birthDate));

        return user;

    }

    public UserPJ toUserPJ() {

        UserPJ user = new UserPJ();

        user.setCnpj(this.document);
        user.setName(this.name);
        user.setBirthDate(ConvertStringToDate.convert(this.birthDate));

        return user;

    }
}
