package com.brunoandreotti.projeto_cadastro_spring.service.register;

import com.brunoandreotti.projeto_cadastro_spring.controller.dtos.UserRequestDTO;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import com.brunoandreotti.projeto_cadastro_spring.exception.InvalidDocumentException;
import com.brunoandreotti.projeto_cadastro_spring.exception.UserAlreadyExistsException;
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

import java.time.format.DateTimeParseException;
import java.util.Optional;

@DisplayName("RegisterServicesImpl unit tests")
@ExtendWith(MockitoExtension.class)
public class RegisterServiceImplTest {

    @Mock
    private UserPFRepository userPFRepository;

    @Mock
    private UserPJRepository userPJRepository;

    @InjectMocks
    private RegisterServiceImpl registerService;


    @Nested
    @DisplayName("registerPF method tests")
    class registerPF {

        @Test
        @DisplayName("Should register PF User with valid data")
        void shouldRegisterPFUser() {

            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/1998", "99999999999");
            UserPF userWithId = new UserPF(1L, userRequestDTO.name(), ConvertStringToDate.convert(userRequestDTO.birthDate()), userRequestDTO.document());


            Mockito.when(userPFRepository.findByCpf(userRequestDTO.document())).thenReturn(Optional.empty());
            Mockito.when(userPFRepository.save(userRequestDTO.toUserPF())).thenReturn(userWithId);

            UserPF response = registerService.registerPF(userRequestDTO);

            Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(userWithId);

        }

        @Test
        @DisplayName("Should not register PF User with invalid document")
        void shouldNotRegisterPFUserWithInvalidDocument() {
            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/1998", "9999999999");

            String exceptionMessage = StringConstants.INVALID_PF_DOC;

            Assertions.assertThatThrownBy(() -> registerService.registerPF(userRequestDTO)).isInstanceOf(InvalidDocumentException.class).hasMessage(exceptionMessage);
        }

        @Test
        @DisplayName("Should not register PF User with existing document")
        void shouldNotRegisterPFUserWithExistingDocument() {
            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/1998", "99999999999");

            Mockito.when(userPFRepository.findByCpf(userRequestDTO.document())).thenReturn(Optional.of(Mockito.mock(UserPF.class)));

            String exceptionMessage = StringConstants.USER_EXISTS_ERROR;

            Assertions.assertThatThrownBy(() -> registerService.registerPF(userRequestDTO)).isInstanceOf(UserAlreadyExistsException.class).hasMessage(exceptionMessage);
        }

        @Test
        @DisplayName("Should not register PF User with invalid birth date")
        void shouldNotRegisterPFUserWithInvalidBirthDate() {
            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/199", "99999999999");

            Mockito.when(userPFRepository.findByCpf(userRequestDTO.document())).thenReturn(Optional.empty());

            Assertions.assertThatThrownBy(() -> registerService.registerPF(userRequestDTO)).isInstanceOf(DateTimeParseException.class);
        }
    }


    @Nested
    @DisplayName("registerPJ method tests")
    class registerPJ {


        @Test
        @DisplayName("Should register PJ User with valid data")
        void shouldRegisterPJUser() {

            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/1998", "999999999999");
            UserPJ userWithId = new UserPJ(1L, userRequestDTO.name(), ConvertStringToDate.convert(userRequestDTO.birthDate()), userRequestDTO.document());


            Mockito.when(userPJRepository.findByCnpj(userRequestDTO.document())).thenReturn(Optional.empty());
            Mockito.when(userPJRepository.save(userRequestDTO.toUserPJ())).thenReturn(userWithId);

            UserPJ response = registerService.registerPJ(userRequestDTO);

            Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(userWithId);

        }

        @Test
        @DisplayName("Should not register PJ User with invalid document")
        void shouldNotRegisterPJUserWithInvalidDocument() {
            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/1998", "9999999999");

            String exceptionMessage = StringConstants.INVALID_PJ_DOC;

            Assertions.assertThatThrownBy(() -> registerService.registerPJ(userRequestDTO)).isInstanceOf(InvalidDocumentException.class).hasMessage(exceptionMessage);
        }

        @Test
        @DisplayName("Should not register PJ User with existing document")
        void shouldNotRegisterPJUserWithExistingDocument() {
            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/1998", "999999999999");

            Mockito.when(userPJRepository.findByCnpj(userRequestDTO.document())).thenReturn(Optional.of(Mockito.mock(UserPJ.class)));

            String exceptionMessage = StringConstants.USER_EXISTS_ERROR;

            Assertions.assertThatThrownBy(() -> registerService.registerPJ(userRequestDTO)).isInstanceOf(UserAlreadyExistsException.class).hasMessage(exceptionMessage);
        }

        @Test
        @DisplayName("Should not register PJ User with invalid birth date")
        void shouldNotRegisterPJUserWithInvalidBirthDate() {
            UserRequestDTO userRequestDTO = new UserRequestDTO("Teste", "09/01/199", "999999999999");

            Mockito.when(userPJRepository.findByCnpj(userRequestDTO.document())).thenReturn(Optional.empty());

            Assertions.assertThatThrownBy(() -> registerService.registerPJ(userRequestDTO)).isInstanceOf(DateTimeParseException.class);
        }
    }


}
