package com.homework.silenteight.service;

import com.homework.silenteight.entity.GenderType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenderServiceImplTest {

    private GenderServiceImpl service = new GenderServiceImpl();

    @Test
    void shouldFindSinglePersonGender() {
        assertEquals(GenderType.MALE.toString(), service.findFirstPersonGender("sam"));
    }

    @Test
    void shouldThrowINCONCLUSIVEMessage() {
        assertEquals(GenderType.INCONCLUSIVE.name(), service.findFirstPersonGender("soInvalidName"));
    }

    @Test
    void whenEqualNumberOfMaleAndFemale() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Wilt");
        nameList.add("adaline");
        nameList.add("mignonne");
        nameList.add("Gregory");
        assertEquals(GenderType.INCONCLUSIVE.name(), service.findAllPersonGender(nameList));
    }

    @Test
    void whenNumberOfMaleGreaterThenFemale() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Wilt");
        nameList.add("adaline");
        nameList.add("Gregory");
        assertEquals(GenderType.MALE.name(), service.findAllPersonGender(nameList));
    }

    @Test
    void whenNumberOfFemaleGreaterThenMale() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Wilt");
        nameList.add("adaline");
        nameList.add("mignonne");
        assertEquals(GenderType.FEMALE.name(), service.findAllPersonGender(nameList));
    }
}