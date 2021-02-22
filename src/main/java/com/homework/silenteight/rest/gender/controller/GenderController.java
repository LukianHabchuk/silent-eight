package com.homework.silenteight.rest.gender.controller;

import com.homework.silenteight.rest.gender.entity.AlgorithmType;
import com.homework.silenteight.entity.GenderType;
import com.homework.silenteight.rest.gender.exceptions.WrongAlgorithmTypeException;
import com.homework.silenteight.rest.gender.service.GenderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static com.homework.silenteight.constants.Constants.GENDER_CONTROLLER_GET_GENDER_MAPPING;
import static com.homework.silenteight.constants.Constants.GENDER_CONTROLLER_REQUEST_MAPPING;

@RestController
@RequestMapping(GENDER_CONTROLLER_REQUEST_MAPPING)
public class GenderController {

    private GenderServiceImpl service = new GenderServiceImpl();

    @ApiOperation(value = "Returns persons gender/s by given name and chosen algorithm")
    @GetMapping(GENDER_CONTROLLER_GET_GENDER_MAPPING)
    public String getGender(@RequestParam("name") String name, @RequestParam("algorithm") AlgorithmType type) {
        if (type != AlgorithmType.FIRST && type != AlgorithmType.ALL)
            throw new WrongAlgorithmTypeException();
        if (type.name().equals(AlgorithmType.FIRST.name()))
            return service.findFirstPersonGender(name);
        else if (type.name().equals(AlgorithmType.ALL.name()))
            return service.findAllPersonGender(Arrays.asList(name.split(" ")));
        else return GenderType.INCONCLUSIVE.name();
    }

}
