package com.homework.silenteight.rest.gender.service;

import com.homework.silenteight.rest.gender.service.algorithm.GenderAlgorithm;
import com.homework.silenteight.entity.GenderType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    private GenderAlgorithm algorithm = new GenderAlgorithm();

    @Override
    public String findFirstPersonGender(String name) {
        return algorithm.search(name);
    }

    @Override
    public String findAllPersonGender(List<String> names) {
        List<String> result = new ArrayList<>();
        names.forEach(e -> result.add(algorithm.search(e)));

        var maleCount = Collections.frequency(result, GenderType.MALE.name());
        var femaleCount = Collections.frequency(result, GenderType.FEMALE.name());

        if (result.isEmpty() || maleCount == femaleCount)
            return GenderType.INCONCLUSIVE.name();

        return maleCount > femaleCount ? GenderType.MALE.name()
                : GenderType.FEMALE.name();
    }

}
