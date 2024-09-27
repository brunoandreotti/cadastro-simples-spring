package com.brunoandreotti.projeto_cadastro_spring.service.delete;

import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeleteServiceImplTest {



        @Mock
        private UserPJRepository userPJRepository;

        @InjectMocks
        private DeleteServiceImpl deleteService;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void test_deletePJ_successful_deletion() {
            Long validId = 1L;
            doNothing().when(userPJRepository).deleteById(validId);

            deleteService.deletePJ(validId);

            verify(userPJRepository, times(1)).deleteById(validId);
        }

        @Test
        public void test_deletePJ_successful_deletion_2() {
            UserPJRepository userPJRepository = Mockito.mock(UserPJRepository.class);
            DeleteServiceImpl deleteService = new DeleteServiceImpl(null, userPJRepository);

            Long validId = 1L;
            Mockito.when(userPJRepository.existsById(validId)).thenReturn(true);

            deleteService.deletePJ(validId);

            Mockito.verify(userPJRepository, Mockito.times(1)).deleteById(validId);
        }

    @Test
    public void test_deletePJ_successful_deletion_3() {
        UserPJRepository userPJRepository = Mockito.mock(UserPJRepository.class);
        DeleteServiceImpl deleteService = new DeleteServiceImpl(null, userPJRepository);

        56 +        Long validId = 1L;
        57 +        Mockito.when(userPJRepository.existsById(validId)).thenReturn(true);
        59 +
        60 +        // Verify the deletion
        61 +        deleteService.deletePJ(validId);
        62 +
        63 +        // Verify that deleteById was called with the correct id
        64 +        Mockito.verify(userPJRepository, Mockito.times(1)).deleteById(validId);
    }

}
