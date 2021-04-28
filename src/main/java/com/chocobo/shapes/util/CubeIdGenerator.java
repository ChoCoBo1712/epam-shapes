package com.chocobo.shapes.util;

public class CubeIdGenerator {

    private static long counter;

    private CubeIdGenerator() { }

    public static long generateId() {
        return ++counter;
    }
}
