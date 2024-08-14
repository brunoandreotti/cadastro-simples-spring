package com.brunoandreotti.projeto_cadastro_spring.service.list;

import com.brunoandreotti.projeto_cadastro_spring.entity.UserPF;
import com.brunoandreotti.projeto_cadastro_spring.entity.UserPJ;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPFRepository;
import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;
import com.brunoandreotti.projeto_cadastro_spring.util.ConvertStringToDate;
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

@DisplayName("ListServicesImpl unit tests")
@ExtendWith(MockitoExtension.class)
public class ListServiceImplTest {

    @Mock
    private UserPFRepository userPFRepository;

    @Mock
    private UserPJRepository userPJRepository;


    @InjectMocks
    private ListServiceImpl listService;

    @Nested
    @DisplayName("UserPF tests")
    class UserPFTests {
        @Nested
        @DisplayName("listPF methods tests")
        class listPF {

            @Test
            @DisplayName("Should call findAllByOrderByNameAsc")
            void shouldCallFindAllByOrderByNameAsc() {
                String type = "name";
                String order = "asc";

                listService.listPF(type, order);

                Mockito.verify(userPFRepository, Mockito.times(1)).findAllByOrderByNameAsc();

            }

            @Test
            @DisplayName("Should call findAllByOrderByNameDesc")
            void shouldCallFindAllByOrderByNameDesc() {
                String type = "name";
                String order = "desc";

                listService.listPF(type, order);

                Mockito.verify(userPFRepository, Mockito.times(1)).findAllByOrderByNameDesc();

            }

            @Test
            @DisplayName("Should call findAllByOrderByBirthDateDesc")
            void shouldCallFindAllByOrderByBirthDateDesc() {
                String type = "age";
                String order = "asc";

                listService.listPF(type, order);

                Mockito.verify(userPFRepository, Mockito.times(1)).findAllByOrderByBirthDateDesc();

            }

            @Test
            @DisplayName("Should call findAllByOrderByBirthDateAsc")
            void shouldCallFindAllByOrderByBirthDateAsc() {
                String type = "age";
                String order = "desc";

                listService.listPF(type, order);

                Mockito.verify(userPFRepository, Mockito.times(1)).findAllByOrderByBirthDateAsc();

            }

        }

        @Nested
        @DisplayName("listPFByName methods tests")
        class listPFByName {

            @Test
            @DisplayName("Should list PF Users ordered by name asc")
            void shouldListPfUsersByNameAsc() {

                UserPF user1 = new UserPF(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "99999999999");
                UserPF user2 = new UserPF(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "99999999998");

                List<UserPF> usersList = List.of(user1, user2);

                Mockito.when(userPFRepository.findAllByOrderByNameAsc()).thenReturn(usersList);

                List<UserPF> result = listService.listPFByNameAsc();

                Assertions.assertThat(result.getFirst().getName()).isEqualTo(user1.getName());
                Assertions.assertThat(result.get(1).getName()).isEqualTo(user2.getName());
            }

            @Test
            @DisplayName("Should list PF Users ordered by name desc")
            void shouldListPfUsersByNameDesc() {

                UserPF user1 = new UserPF(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "99999999999");
                UserPF user2 = new UserPF(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "99999999998");

                List<UserPF> usersList = List.of(user2, user1);

                Mockito.when(userPFRepository.findAllByOrderByNameDesc()).thenReturn(usersList);

                List<UserPF> result = listService.listPFByNameDesc();

                Assertions.assertThat(result.getFirst().getName()).isEqualTo(user2.getName());
                Assertions.assertThat(result.get(1).getName()).isEqualTo(user1.getName());
            }
        }

        @Nested
        @DisplayName("listPFByAge methods tests")
        class listPFByAge {


            @Test
            @DisplayName("Should list PF Users ordered by age asc")
            void shouldListPFUsersByAgeAsc() {
                UserPF user1 = new UserPF(1L, "ATest", ConvertStringToDate.convert("09/09/1999"), "99999999999");
                UserPF user2 = new UserPF(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "99999999998");

                List<UserPF> usersList = List.of(user1, user2);

                Mockito.when(userPFRepository.findAllByOrderByBirthDateDesc()).thenReturn(usersList);

                List<UserPF> result = listService.listPFByAgeAsc();

                Assertions.assertThat(result.getFirst().getBirthDate()).isEqualTo(user1.getBirthDate());
                Assertions.assertThat(result.get(1).getBirthDate()).isEqualTo(user2.getBirthDate());
            }

            @Test
            @DisplayName("Should list PF Users ordered by age desc")
            void shouldListPFUsersByAgeDesc() {
                UserPF user1 = new UserPF(1L, "ATest", ConvertStringToDate.convert("09/09/1999"), "99999999999");
                UserPF user2 = new UserPF(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "99999999998");

                List<UserPF> usersList = List.of(user2, user1);

                Mockito.when(userPFRepository.findAllByOrderByBirthDateAsc()).thenReturn(usersList);

                List<UserPF> result = listService.listPFByAgeDesc();

                Assertions.assertThat(result.getFirst().getBirthDate()).isEqualTo(user2.getBirthDate());
                Assertions.assertThat(result.get(1).getBirthDate()).isEqualTo(user1.getBirthDate());
            }

        }
    }

    @Nested
    @DisplayName("UserPJ tests")
    class UserPJTests {
        @Nested
        @DisplayName("listPJ methods tests")
        class listPJ {

            @Test
            @DisplayName("Should call findAllByOrderByNameAsc")
            void shouldCallFindAllByOrderByNameAsc() {
                String type = "name";
                String order = "asc";

                listService.listPJ(type, order);

                Mockito.verify(userPJRepository, Mockito.times(1)).findAllByOrderByNameAsc();

            }

            @Test
            @DisplayName("Should call findAllByOrderByNameDesc")
            void shouldCallFindAllByOrderByNameDesc() {
                String type = "name";
                String order = "desc";

                listService.listPJ(type, order);

                Mockito.verify(userPJRepository, Mockito.times(1)).findAllByOrderByNameDesc();

            }

            @Test
            @DisplayName("Should call findAllByOrderByBirthDateDesc")
            void shouldCallFindAllByOrderByBirthDateDesc() {
                String type = "age";
                String order = "asc";

                listService.listPJ(type, order);

                Mockito.verify(userPJRepository, Mockito.times(1)).findAllByOrderByBirthDateDesc();

            }

            @Test
            @DisplayName("Should call findAllByOrderByBirthDateAsc")
            void shouldCallFindAllByOrderByBirthDateAsc() {
                String type = "age";
                String order = "desc";

                listService.listPJ(type, order);

                Mockito.verify(userPJRepository, Mockito.times(1)).findAllByOrderByBirthDateAsc();

            }

        }


        @Nested
        @DisplayName("listPJByName methods tests")
        class listPJByName {
            @Test
            @DisplayName("Should list PF Users ordered by name asc")
            void shouldListPjUsersByNameAsc() {

                UserPJ user1 = new UserPJ(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "999999999998");
                UserPJ user2 = new UserPJ(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "999999999999");

                List<UserPJ> usersList = List.of(user1, user2);

                Mockito.when(userPJRepository.findAllByOrderByNameAsc()).thenReturn(usersList);

                List<UserPJ> result = listService.listPJByNameAsc();

                Assertions.assertThat(result.getFirst().getName()).isEqualTo(user1.getName());
                Assertions.assertThat(result.get(1).getName()).isEqualTo(user2.getName());
            }

            @Test
            @DisplayName("Should list PF Users ordered by name asc")
            void shouldListPjUsersByNameDesc() {

                UserPJ user1 = new UserPJ(1L, "ATest", ConvertStringToDate.convert("09/09/1990"), "999999999998");
                UserPJ user2 = new UserPJ(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "999999999999");

                List<UserPJ> usersList = List.of(user2, user1);

                Mockito.when(userPJRepository.findAllByOrderByNameDesc()).thenReturn(usersList);

                List<UserPJ> result = listService.listPJByNameDesc();

                Assertions.assertThat(result.getFirst().getName()).isEqualTo(user2.getName());
                Assertions.assertThat(result.get(1).getName()).isEqualTo(user1.getName());
            }
        }


        @Nested
        @DisplayName("listPJByAge methods tests")
        class listPJByAge {


            @Test
            @DisplayName("Should list PF Users ordered by age asc")
            void shouldListPFUsersByAgeAsc() {
                UserPJ user1 = new UserPJ(1L, "ATest", ConvertStringToDate.convert("09/09/1999"), "999999999999");
                UserPJ user2 = new UserPJ(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "999999999988");

                List<UserPJ> usersList = List.of(user1, user2);

                Mockito.when(userPJRepository.findAllByOrderByBirthDateDesc()).thenReturn(usersList);

                List<UserPJ> result = listService.listPJByAgeAsc();

                Assertions.assertThat(result.getFirst().getBirthDate()).isEqualTo(user1.getBirthDate());
                Assertions.assertThat(result.get(1).getBirthDate()).isEqualTo(user2.getBirthDate());
            }

            @Test
            @DisplayName("Should list PF Users ordered by age desc")
            void shouldListPFUsersByAgeDesc() {
                UserPJ user1 = new UserPJ(1L, "ATest", ConvertStringToDate.convert("09/09/1999"), "999999999999");
                UserPJ user2 = new UserPJ(2L, "BTest", ConvertStringToDate.convert("09/09/1990"), "999999999988");

                List<UserPJ> usersList = List.of(user2, user1);

                Mockito.when(userPJRepository.findAllByOrderByBirthDateAsc()).thenReturn(usersList);

                List<UserPJ> result = listService.listPJByAgeDesc();

                Assertions.assertThat(result.getFirst().getBirthDate()).isEqualTo(user2.getBirthDate());
                Assertions.assertThat(result.get(1).getBirthDate()).isEqualTo(user1.getBirthDate());
            }

        }
    }


}
