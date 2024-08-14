package com.brunoandreotti.projeto_cadastro_spring.service.list;


import com.brunoandreotti.projeto_cadastro_spring.entity.User;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import com.brunoandreotti.projeto_cadastro_spring.exception.InvalidQueryParamException;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPFRepository;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;
import com.brunoandreotti.projeto_cadastro_spring.util.StringConstants;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class ListServiceImpl implements ListService {

    private final UserPFRepository userPFRepository;
    private final UserPJRepository userPJRepository;

    public ListServiceImpl(UserPFRepository userPFRepository, UserPJRepository userPJRepository) {
        this.userPFRepository = userPFRepository;
        this.userPJRepository = userPJRepository;
    }

    @Override
    public List<UserPF> listPF(String type, String order) {

        if (!StringConstants.VALID_GET_TYPES.contains(type) || !StringConstants.VALID_ORDER_TYPES.contains(order)) {
            throw new InvalidQueryParamException(StringConstants.INVALID_QUERY_PARAM);
        }

        return listPFMethodStrategy(type, order);
    }

    @Override
    public List<UserPJ> listPJ(String type, String order) {
        if (!StringConstants.VALID_GET_TYPES.contains(type) || !StringConstants.VALID_ORDER_TYPES.contains(order)) {
            throw new InvalidQueryParamException(StringConstants.INVALID_QUERY_PARAM);
        }

        return listPJMethodStrategy(type, order);
    }

    @Override
    public List<UserPF> listPFByNameAsc() {
        return userPFRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<UserPF> listPFByNameDesc() {
        return userPFRepository.findAllByOrderByNameDesc();
    }

    @Override
    public List<UserPJ> listPJByNameAsc() {
        return userPJRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<UserPJ> listPJByNameDesc() {
        return userPJRepository.findAllByOrderByNameDesc();
    }

    @Override
    public List<UserPF> listPFByAgeAsc() {
        return userPFRepository.findAllByOrderByBirthDateDesc();
    }

    @Override
    public List<UserPF> listPFByAgeDesc() {
        return userPFRepository.findAllByOrderByBirthDateAsc();
    }

    @Override
    public List<UserPJ> listPJByAgeAsc() {
        return userPJRepository.findAllByOrderByBirthDateDesc();
    }

    @Override
    public List<UserPJ> listPJByAgeDesc() {
        return userPJRepository.findAllByOrderByBirthDateAsc();
    }

    private List<UserPF> listPFMethodStrategy(String type, String order) {

        Map<List<String>, List<UserPF>> strategyMap = Map.of(
                List.of("name", "asc"), listPFByNameAsc(),
                List.of("name", "desc"), listPFByNameDesc(),
                List.of("age", "asc"), listPFByAgeAsc(),
                List.of("age", "desc"), listPFByAgeDesc()
        );

        return strategyMap.get(List.of(type, order));
    }

    private List<UserPJ> listPJMethodStrategy(String type, String order) {

        Map<List<String>, List<UserPJ>> strategyMap = Map.of(
                List.of("name", "asc"), listPJByNameAsc(),
                List.of("name", "desc"), listPJByNameDesc(),
                List.of("age", "asc"), listPJByAgeAsc(),
                List.of("age", "desc"), listPJByAgeDesc()
        );

        return strategyMap.get(List.of(type, order));
    }
}
