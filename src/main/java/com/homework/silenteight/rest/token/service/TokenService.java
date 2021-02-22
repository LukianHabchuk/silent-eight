package com.homework.silenteight.rest.token.service;

import com.homework.silenteight.rest.token.entity.PersonToken;

import java.util.List;

public interface TokenService {

    List<PersonToken> getAllTokens();

    List<PersonToken> getMaleTokens();

    List<PersonToken> getFemaleTokens();

}
