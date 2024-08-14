package com.brunoandreotti.projeto_cadastro_spring.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertStringToDate {

    public static LocalDate convert(String stringDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(stringDate, formatter);

    }
}
