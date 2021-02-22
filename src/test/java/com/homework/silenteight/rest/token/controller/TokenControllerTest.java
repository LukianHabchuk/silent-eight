package com.homework.silenteight.rest.token.controller;

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

import static com.homework.silenteight.constants.Constants.*;

@SpringBootTest
@AutoConfigureMockMvc
class TokenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    TokenController controller;

    @Autowired
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldPrintAllTokens() throws Exception {
        String uri = TOKEN_CONTROLLER_REQUEST_MAPPING + TOKEN_CONTROLLER_GET_ALL_MAPPING;

        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(org.hamcrest.Matchers.containsString(GenderType.MALE.name())))
                .andExpect(MockMvcResultMatchers.content().string(org.hamcrest.Matchers.containsString(GenderType.FEMALE.name())));
    }

    @Test
    void shouldPrintMaleTokens() throws Exception {
        String uri = TOKEN_CONTROLLER_REQUEST_MAPPING + TOKEN_CONTROLLER_GET_MALE_MAPPING;
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(org.hamcrest.Matchers.containsString(GenderType.MALE.name())));
    }

    @Test
    void shouldPrintFemaleTokens() throws Exception {
        String uri = TOKEN_CONTROLLER_REQUEST_MAPPING + TOKEN_CONTROLLER_GET_FEMALE_MAPPING;
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(org.hamcrest.Matchers.containsString(GenderType.FEMALE.name())));
    }
}