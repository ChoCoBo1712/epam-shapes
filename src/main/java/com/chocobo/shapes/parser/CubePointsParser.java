package com.chocobo.shapes.parser;

import java.util.Arrays;

public class CubePointsParser {

    public static final String SPLITTER = ",";

    public double[] parse(String line) {
        return Arrays.stream(line.split(SPLITTER))
                .map(String::trim)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
