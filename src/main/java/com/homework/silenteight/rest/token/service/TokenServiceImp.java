package com.homework.silenteight.rest.token.service;

import com.homework.silenteight.rest.token.service.algorithm.TokenAlgorithm;
import com.homework.silenteight.rest.token.entity.PersonToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceImp implements TokenService {

    private TokenAlgorithm algorithm = new TokenAlgorithm();

    @Override
    public List<PersonToken> getAllTokens() {
        return algorithm.getAllTokens();
    }

    @Override
    public List<PersonToken> getMaleTokens() {
        return algorithm.getMale();
    }

    @Override
    public List<PersonToken> getFemaleTokens() {
        return algorithm.getFemale();
    }
}
