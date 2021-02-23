package com.homework.silenteight.constants;

public class Constants {

    Constants() {
    }

    //path to local files with female and male tokens
    public static final String MALE_NAMES_FILE_PATH = "genderNames/male.txt";
    public static final String FEMALE_NAMES_FILE_PATH = "genderNames/female.txt";

    //gender mapping
    public static final String GENDER_CONTROLLER_REQUEST_MAPPING = "/api/gender";
    public static final String GENDER_CONTROLLER_GET_GENDER_MAPPING = "/name";

    //token mapping
    public static final String TOKEN_CONTROLLER_REQUEST_MAPPING = "/api/tokens";
    public static final String TOKEN_CONTROLLER_GET_ALL_MAPPING = "/all";
    public static final String TOKEN_CONTROLLER_GET_MALE_MAPPING = "/male";
    public static final String TOKEN_CONTROLLER_GET_FEMALE_MAPPING = "/female";
}
