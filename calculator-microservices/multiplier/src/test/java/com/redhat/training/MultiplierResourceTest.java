package com.redhat.training;

import static org.mockito.Mockito.mock;

import com.redhat.training.service.SolverService;

import org.junit.jupiter.api.BeforeEach;

public class MultiplierResourceTest {
    
    SolverService solverService;
    MultiplierResource multiplierResource;

    @BeforeEach
    public void setup() {
        solverService = mock(SolverService.class);
        multiplierResource = new MultiplierResource(solverService);
    }


    @Test
    public void simpleMultiplication() {
        // Given
        Mockito.when(solverService.solve("2")).thenReturn(Float.valueOf("2"));
        Mockito.when(solverService.solve("3")).thenReturn(Float.valueOf("3"));

        // When
        Float result = multiplierResource.multiply("2", "3");

        // Then
        assertEquals( 6.0f, result );
    }
}
