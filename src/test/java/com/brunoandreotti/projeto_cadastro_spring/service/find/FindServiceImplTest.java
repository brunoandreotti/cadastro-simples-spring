package com.brunoandreotti.projeto_cadastro_spring.service.find;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import com.brunoandreotti.projeto_cadastro_spring.exception.UserNotFoundException;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPFRepository;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;

import com.brunoandreotti.projeto_cadastro_spring.util.ConvertStringToDate;
import com.brunoandreotti.projeto_cadastro_spring.util.StringConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@DisplayName("FindServicesImpl unit tests")
@ExtendWith(MockitoExtension.class)
public class FindServiceImplTest {

    @Mock
    private UserPFRepository userPFRepository;

    @Mock
    private UserPJRepository userPJRepository;


    @InjectMocks
    FindServiceImpl findService;

    @Nested
    @DisplayName("UserPF tests")
    class UserPFTests {
        @Nested
        @DisplayName("findPFByDocument method tests")
        class findPFByDocument {

            @Test
            @DisplayName("Should find User PF using valid document")
            void shouldFindUserPFByDocument() {
                UserPF user1 = new UserPF(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "99999999999");

                Mockito.when(userPFRepository.findByCpf(user1.getCpf())).thenReturn(Optional.of(user1));

                UserPF result = findService.findPFByDocument(user1.getCpf());

                Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(user1);
            }

            @Test
            @DisplayName("Should not find User PF using invalid document")
            void shouldNotFindUserPFByDocument() {

                String wrongCPF = "0000";

                Mockito.when(userPFRepository.findByCpf(wrongCPF)).thenReturn(Optional.empty());

                String errorMessage = String.format(StringConstants.USER_NOT_FOUND, "CPF", wrongCPF);

                Assertions.assertThatThrownBy(() -> findService.findPFByDocument(wrongCPF)).isInstanceOf(UserNotFoundException.class).hasMessage(errorMessage);
            }

        }

        @Nested
        @DisplayName("findPFById method tests")
        class findPFById {


            @Test
            @DisplayName("Should find User PF using valid Id")
            void shouldFindUserPFByDocument() {
                UserPF user1 = new UserPF(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "99999999999");

                Mockito.when(userPFRepository.findById(user1.getId())).thenReturn(Optional.of(user1));

                UserPF result = findService.findPFById(user1.getId());

                Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(user1);
            }

            @Test
            @DisplayName("Should not find User PF using invalid document")
            void shouldNotFindUserPFByDocument() {

                Long wrongId = 2L;

                Mockito.when(userPFRepository.findById(wrongId)).thenReturn(Optional.empty());

                String errorMessage = String.format(StringConstants.USER_NOT_FOUND, "ID", wrongId);

                Assertions.assertThatThrownBy(() -> findService.findPFById(wrongId)).isInstanceOf(UserNotFoundException.class).hasMessage(errorMessage);
            }

        }

        @Nested
        @DisplayName("findPFByName method tests")
        class findPFByName {


            @Test
            @DisplayName("Should find User PF using valid Name")
            void shouldFindUserPFByName() {
                UserPF user1 = new UserPF(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "99999999999");

                Mockito.when(userPFRepository.findByNameContaining(user1.getName())).thenReturn(List.of(user1));

                List<UserPF> result = findService.findPFByName(user1.getName());

                Assertions.assertThat(result.getFirst()).usingRecursiveComparison().isEqualTo(user1);
            }

            @Test
            @DisplayName("Should not find User PF using invalid name")
            void shouldNotFindUserPFByDocument() {

                String wrongName = "Wrong name";

                Mockito.when(userPFRepository.findByNameContaining(wrongName)).thenReturn(List.of());

                List<UserPF> result = findService.findPFByName(wrongName);

                Assertions.assertThat(result.size()).isEqualTo(0);
            }

        }
    }

    @Nested
    @DisplayName("UserPJ tests")
    class UserPJTests {
        @Nested
        @DisplayName("findPJByDocument method tests")
        class findPJByDocument {


            @Test
            @DisplayName("Should find User PJ using valid document")
            void shouldFindUserPJByDocument() {
                UserPJ user1 = new UserPJ(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "999999999999");

                Mockito.when(userPJRepository.findByCnpj(user1.getCnpj())).thenReturn(Optional.of(user1));

                UserPJ result = findService.findPJByDocument(user1.getCnpj());

                Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(user1);
            }

            @Test
            @DisplayName("Should not find User PJ using invalid document")
            void shouldNotFindUserPJByDocument() {

                String wrongCPJ = "0000";

                Mockito.when(userPJRepository.findByCnpj(wrongCPJ)).thenReturn(Optional.empty());

                String errorMessage = String.format(StringConstants.USER_NOT_FOUND, "CNPJ", wrongCPJ);

                Assertions.assertThatThrownBy(() -> findService.findPJByDocument(wrongCPJ)).isInstanceOf(UserNotFoundException.class).hasMessage(errorMessage);
            }

        }

        @Nested
        @DisplayName("findPJById method tests")
        class findPJById {


            @Test
            @DisplayName("Should find User PJ using valid Id")
            void shouldFindUserPJByDocument() {
                UserPJ user1 = new UserPJ(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "999999999999");

                Mockito.when(userPJRepository.findById(user1.getId())).thenReturn(Optional.of(user1));

                UserPJ result = findService.findPJById(user1.getId());

                Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(user1);
            }

            @Test
            @DisplayName("Should not find User PJ using invalid document")
            void shouldNotFindUserPJByDocument() {

                Long wrongId = 2L;

                Mockito.when(userPJRepository.findById(wrongId)).thenReturn(Optional.empty());

                String errorMessage = String.format(StringConstants.USER_NOT_FOUND, "ID", wrongId);

                Assertions.assertThatThrownBy(() -> findService.findPJById(wrongId)).isInstanceOf(UserNotFoundException.class).hasMessage(errorMessage);
            }

        }

        @Nested
        @DisplayName("findPJByName method tests")
        class findPJByName {


            @Test
            @DisplayName("Should find User PJ using valid Name")
            void shouldFindUserPJByName() {
                UserPJ user1 = new UserPJ(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "999999999999");

                Mockito.when(userPJRepository.findByNameContaining(user1.getName())).thenReturn(List.of(user1));

                List<UserPJ> result = findService.findPJByName(user1.getName());

                Assertions.assertThat(result.getFirst()).usingRecursiveComparison().isEqualTo(user1);
            }

            @Test
            @DisplayName("Should not find User PJ using invalid name")
            void shouldNotFindUserPJByDocument() {

                String wrongName = "Wrong name";

                Mockito.when(userPJRepository.findByNameContaining(wrongName)).thenReturn(List.of());

                List<UserPJ> result = findService.findPJByName(wrongName);

                Assertions.assertThat(result.size()).isEqualTo(0);
            }

        }
    }


}
