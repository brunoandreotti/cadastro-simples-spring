package com.brunoandreotti.projeto_cadastro_spring.util;


import java.util.List;

public class StringConstants {

    public static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

    public static final String DOCUMENT_FORMAT_REGEX = "\\d+";

    public static final String INVALID_PF_DOC = "Documento inválido, é necessário ter 11 dígitos";

    public static final String INVALID_PJ_DOC = "Documento inválido, é necessário ter 12 dígitos";

    public static final String USER_EXISTS_ERROR = "Usuário com o documento utilizado já existe";

    public static final String INVALID_QUERY_PARAM = "'Type' deve ser name ou age e 'Order' deve ser asc ou desc";

    public static final List<String> VALID_GET_TYPES = List.of("name", "age");

    public static final List<String> VALID_ORDER_TYPES = List.of("asc", "desc");

    public static final String USER_NOT_FOUND = "Usuário com o %s %s não encontrado";
}
