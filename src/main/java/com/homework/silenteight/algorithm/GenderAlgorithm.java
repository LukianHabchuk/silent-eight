package com.homework.silenteight.algorithm;

import com.homework.silenteight.entity.GenderType;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.homework.silenteight.constants.Constants.FEMALE_NAMES_FILE_PATH;
import static com.homework.silenteight.constants.Constants.MALE_NAMES_FILE_PATH;

public class GenderAlgorithm {

    private String personName;

    public String search(String personName) {
        String[] names = personName.split(" ");
        this.personName = names[0];

        return isMale() ? GenderType.MALE.name()
                : isFemale() ? GenderType.FEMALE.name()
                : GenderType.INCONCLUSIVE.name();
    }

    private boolean isMale() {
        try (var br = new BufferedReader(new FileReader(new File(MALE_NAMES_FILE_PATH)))) {
            return search(br);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isFemale() {
        try (var br = new BufferedReader(new FileReader(new File(FEMALE_NAMES_FILE_PATH)))) {
            return search(br);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean search(BufferedReader br) {
        try {
            String line;
            while ((line = br.readLine()) != null)
                if (line.equalsIgnoreCase(this.personName))
                    return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
