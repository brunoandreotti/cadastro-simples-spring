package com.brunoandreotti.projeto_cadastro_spring.service.delete;

import com.brunoandreotti.projeto_cadastro_spring.repository.UserPJRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
        Long validId = 1L;
        doNothing().when(userPJRepository).deleteById(validId);

        deleteService.deletePJ(validId);

        verify(userPJRepository, times(1)).deleteById(validId);
    }

}
