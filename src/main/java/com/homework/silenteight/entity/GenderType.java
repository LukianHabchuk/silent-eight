package com.homework.silenteight.entity;

public enum GenderType {
    MALE("MALE"),
    FEMALE("FEMALE"),
    INCONCLUSIVE("INCONCLUSIVE");

    private String description;

    GenderType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}