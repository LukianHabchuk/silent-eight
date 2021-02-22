package com.homework.silenteight.service;

import java.util.List;

public interface GenderService {

    String findFirstPersonGender(String name);

    String findAllPersonGender(List<String> names);

}
