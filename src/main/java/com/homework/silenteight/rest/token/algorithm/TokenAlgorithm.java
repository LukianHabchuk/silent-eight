package com.homework.silenteight.rest.token.algorithm;

import com.homework.silenteight.constants.Constants;
import com.homework.silenteight.entity.GenderType;
import com.homework.silenteight.rest.token.entity.PersonToken;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenAlgorithm {

    @SneakyThrows
    public List<PersonToken> getAllTokens() {
        List<PersonToken> tokens = new ArrayList<>();
        tokens.addAll(getMale());
        tokens.addAll(getFemale());
        return tokens;
    }

    @SneakyThrows
    public List<PersonToken> getMale() {
        try (var br = new BufferedReader(new FileReader(new File(Constants.MALE_NAMES_FILE_PATH)))) {
            return search(br, GenderType.MALE);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @SneakyThrows
    public List<PersonToken> getFemale() {
        try (var br = new BufferedReader(new FileReader(new File(Constants.FEMALE_NAMES_FILE_PATH)))) {
            return search(br, GenderType.FEMALE);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private List<PersonToken> search(BufferedReader br, GenderType gender) throws IOException {
        try {
            List<PersonToken> tokenResult = new ArrayList<>();
            String line;
            while((line=br.readLine())!=null) {
                tokenResult.add(new PersonToken(line, gender));
            }
            return tokenResult;
        }
        catch(IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
