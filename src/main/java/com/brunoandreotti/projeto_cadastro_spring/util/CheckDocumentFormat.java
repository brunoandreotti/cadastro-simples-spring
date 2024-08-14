package com.brunoandreotti.projeto_cadastro_spring.util;

public class CheckDocumentFormat {

    public static boolean check(String document, Integer documentLength) {
        return !document.matches("\\d+") || document.length() != documentLength;
    }
}
