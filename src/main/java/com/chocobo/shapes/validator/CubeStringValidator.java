package com.chocobo.shapes.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CubeStringValidator {

    private static final Logger logger = LogManager.getLogger();
    private static final String ONE_OR_MORE_DECIMAL_SYMBOLS_REGEX = "[+-]?\\d+\\.?\\d*";
    public static final String SPLITTER = ",";

    static public boolean isValidString(String line) {
        boolean isValid = Arrays.stream(line.split(SPLITTER))
                .map(String::trim)
                .allMatch(string -> string.matches(ONE_OR_MORE_DECIMAL_SYMBOLS_REGEX));
        logger.info(isValid ? "Read valid string: " + line : "Read invalid string: " + line);
        return isValid;
    }
}
