package com.homework.silenteight.algorithm;

import com.homework.silenteight.constants.Constants;
import com.homework.silenteight.entity.GenderType;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GenderAlgorithm implements Runnable {

    private String personName;

    @SneakyThrows
    public String search(String personName) {
        String[] names = personName.split(" ");
        this.personName = names[0];

        //thread initiation
        var threadMale = new Thread(this);
        var threadFemale = new Thread(this);
        threadMale.setName(GenderType.MALE.name());
        threadFemale.setName(GenderType.FEMALE.name());

        threadMale.start();
        threadFemale.start();

        //waiting while threads do their thing
        threadMale.join();
        threadFemale.join();

        if (threadMale.getName().equals("true"))
            return GenderType.MALE.name();
        else if (threadFemale.getName().equals("true"))
            return GenderType.FEMALE.name();

        return GenderType.INCONCLUSIVE.name();
    }

    /**
     * lines 48 and 50 looks the same BUT threads are different
     * */
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals(GenderType.MALE.name()) && isMale()) //check if its Male
            Thread.currentThread().setName("true"); //setting name for threadMale
        else if (Thread.currentThread().getName().equals(GenderType.FEMALE.name()) && isFemale()) //check if its Female
            Thread.currentThread().setName("true"); //setting name for threadFemale
    }

    private boolean isMale() {
        try (var br = new BufferedReader(new FileReader(new File(Constants.MALE_NAMES_FILE_PATH)))) {
            return search(br);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isFemale() {
        try (var br = new BufferedReader(new FileReader(new File(Constants.FEMALE_NAMES_FILE_PATH)))) {
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
