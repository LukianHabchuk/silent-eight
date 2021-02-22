package com.homework.silenteight.rest.token.controller;

import com.homework.silenteight.rest.token.entity.PersonToken;
import com.homework.silenteight.rest.token.service.TokenServiceImp;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.homework.silenteight.constants.Constants.*;

@RestController
@RequestMapping(TOKEN_CONTROLLER_REQUEST_MAPPING)
public class TokenController {

    private TokenServiceImp service = new TokenServiceImp();

    @ApiOperation(value = "Returns all existed male and female tokens")
    @GetMapping(TOKEN_CONTROLLER_GET_ALL_MAPPING)
    public List<PersonToken> getAll() {
        return service.getAllTokens();
    }

    @ApiOperation(value = "Returns all existed male tokens")
    @GetMapping(TOKEN_CONTROLLER_GET_MALE_MAPPING)
    public List<PersonToken> getMale() {
        return service.getMaleTokens();
    }

    @ApiOperation(value = "Returns all existed female tokens")
    @GetMapping(TOKEN_CONTROLLER_GET_FEMALE_MAPPING)
    public List<PersonToken> getFemale() {
        return service.getFemaleTokens();
    }

}