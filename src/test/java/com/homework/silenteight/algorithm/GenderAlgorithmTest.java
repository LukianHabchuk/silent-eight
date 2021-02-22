package com.homework.silenteight.algorithm;

import com.homework.silenteight.entity.GenderType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GenderAlgorithmTest {

    private GenderAlgorithm genderAlgorithm = new GenderAlgorithm();

    @Test
    void shouldFindMale() {
        assertEquals(GenderType.MALE.name(), genderAlgorithm.search("Zechariah"));
    }

    @Test
    void shouldFindMaleByFirstNameWord() {
        assertEquals(GenderType.MALE.name(), genderAlgorithm.search("Zechariah SecondName"));
    }

    @Test
    void shouldFindFemale() {
        assertEquals(GenderType.FEMALE.name(), genderAlgorithm.search("Abigail"));
    }

    @Test
    void shouldFindFemaleByFirstNameWord() {
        assertEquals(GenderType.FEMALE.name(), genderAlgorithm.search("Abigail SecondName"));
    }

    @Test
    void shouldThrowINCONCLUSIVEMessage() {
        assertEquals(GenderType.INCONCLUSIVE.name(), genderAlgorithm.search("non-existent name"));
    }

    @Test
    void shouldThrowINCONCLUSIVEIfNameIsEmpty() {
        assertEquals(GenderType.INCONCLUSIVE.name(), genderAlgorithm.search(""));
    }

}