package com.homework.silenteight.exceptions;

import java.lang.invoke.WrongMethodTypeException;

public class WrongAlgorithmTypeException extends WrongMethodTypeException {
    public WrongAlgorithmTypeException() {
        super("This exception was thrown due to the wrong choice of the algorithm");
    }
}

