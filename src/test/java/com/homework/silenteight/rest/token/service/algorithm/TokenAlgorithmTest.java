package com.homework.silenteight.rest.token.service.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenAlgorithmTest {

    private TokenAlgorithm algorithm = new TokenAlgorithm();
    private static int FEMALE_FILE_SIZE = 4955;
    private static int MALE_FILE_SIZE = 2943;

    @Test
    void getAllTokens() {
        assertEquals(algorithm.getAllTokens().size(), FEMALE_FILE_SIZE + MALE_FILE_SIZE);
    }

    @Test
    void getMale() {
        assertEquals(algorithm.getMale().size(), MALE_FILE_SIZE);
    }

    @Test
    void getFemale() {
        assertEquals(algorithm.getFemale().size(), FEMALE_FILE_SIZE);
    }
}