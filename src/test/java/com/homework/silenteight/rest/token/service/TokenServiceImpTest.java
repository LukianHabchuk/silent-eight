package com.homework.silenteight.rest.token.service;

import com.homework.silenteight.entity.GenderType;
import com.homework.silenteight.rest.token.entity.PersonToken;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TokenServiceImpTest {

    private TokenServiceImp service = new TokenServiceImp();

    @Test
    void getAllTokens() {
        PersonToken male = new PersonToken("Aamir", GenderType.MALE);
        PersonToken female = new PersonToken("clo", GenderType.FEMALE);
        assertTrue(Objects.equals(service.getAllTokens().get(0).toString(), male.toString())
                && Objects.equals(service.getAllTokens().get(4000).toString(), female.toString()));
    }

    @Test
    void getMaleTokens() {
        PersonToken male = new PersonToken("Aamir", GenderType.MALE);
        assertEquals(service.getMaleTokens().get(0).toString(), male.toString());
    }

    @Test
    void getFemaleTokens() {
        PersonToken female = new PersonToken("aaren", GenderType.FEMALE);
        assertEquals(service.getFemaleTokens().get(0).toString(), female.toString());
    }
}