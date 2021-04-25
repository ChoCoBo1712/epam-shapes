package com.chocobo.shapes.generator;

public class CubeIdGenerator {

    private static long counter;

    private CubeIdGenerator() { }

    public static long generateId() {
        return ++counter;
    }
}
