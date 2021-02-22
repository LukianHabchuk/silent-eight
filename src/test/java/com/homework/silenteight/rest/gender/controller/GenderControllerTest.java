package com.homework.silenteight.rest.gender.controller;

import com.homework.silenteight.rest.gender.entity.AlgorithmType;
import com.homework.silenteight.entity.GenderType;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.homework.silenteight.constants.Constants.GENDER_CONTROLLER_GET_GENDER_MAPPING;
import static com.homework.silenteight.constants.Constants.GENDER_CONTROLLER_REQUEST_MAPPING;

@SpringBootTest
@AutoConfigureMockMvc
class GenderControllerTest {

    private String uri = GENDER_CONTROLLER_REQUEST_MAPPING + GENDER_CONTROLLER_GET_GENDER_MAPPING;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private GenderController controller;

    @Autowired
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldFindMaleGenderByNameAndFirstAlgorithm() throws Exception {
        String name = "Billy"; //randomly chosen name, just for test

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .param("name", name)
                        .param("algorithm", AlgorithmType.FIRST.name()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(GenderType.MALE.name()));
    }

    @Test
    void shouldFindFemaleGenderByNameAndFirstAlgorithm() throws Exception {
        String name = "Eula"; //randomly chosen name, just for test

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .param("name", name)
                        .param("algorithm", AlgorithmType.FIRST.name()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(GenderType.FEMALE.name()));
    }

    @Test
    void shouldNotGenderByWrongNameAndFirstAlgorithm() throws Exception {
        String name = "incorrectName";

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .param("name", name)
                        .param("algorithm", AlgorithmType.FIRST.name()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(GenderType.INCONCLUSIVE.name()));
    }

    @Test
    void shouldFindMaleGenderByNameAndAllAlgorithm() throws Exception {
        String name = "Billy Willy Eula"; //randomly chosen names, just for test

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .param("name", name)
                        .param("algorithm", AlgorithmType.ALL.name()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(GenderType.MALE.name()));
    }

    @Test
    void shouldFindFemaleGenderByNameAndAllAlgorithm() throws Exception {
        String name = "Eula Billy Carri"; //randomly chosen names, just for test

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .param("name", name)
                        .param("algorithm", AlgorithmType.ALL.name()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(GenderType.FEMALE.name()));
    }

    @Test
    void shouldNotFindGenderByWrongNameAndAllAlgorithm() throws Exception {
        String name = "incorrectName Billy Eula";

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .param("name", name)
                        .param("algorithm", AlgorithmType.ALL.name()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(GenderType.INCONCLUSIVE.name()));
    }

    @Test
    void shouldNotFindMaleGenderByNameAndWrongAlgorithm() throws Exception {
        String name = "Billy"; //randomly chosen name, just for test
        String wrongAlgorithmName = "wrongAlgorithm";

        mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
                        .param("name", name)
                        .param("algorithm", wrongAlgorithmName))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}