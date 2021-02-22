package com.homework.silenteight.rest.token.controller;

import com.homework.silenteight.rest.token.entity.PersonToken;
import com.homework.silenteight.rest.token.service.TokenServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.homework.silenteight.constants.Constants.*;

@RestController
@RequestMapping(TOKEN_CONTROLLER_REQUEST_MAPPING)
public class TokenController {

    private TokenServiceImp service = new TokenServiceImp();

    @GetMapping(TOKEN_CONTROLLER_GET_ALL_MAPPING)
    public List<PersonToken> getAll() {
        return service.getAllTokens();
    }

    @GetMapping(TOKEN_CONTROLLER_GET_MALE_MAPPING)
    public List<PersonToken> getMale() {
        return service.getMaleTokens();
    }

    @GetMapping(TOKEN_CONTROLLER_GET_FEMALE_MAPPING)
    public List<PersonToken> getFemale() {
        return service.getFemaleTokens();
    }

}