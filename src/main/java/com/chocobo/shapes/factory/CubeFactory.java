package com.chocobo.shapes.factory;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;

public class CubeFactory {

    private static final int POINTS_AMOUNT = 2;
    public static final int ARRAY_LENGTH = 6;

    private CubeFactory() { }

    public static Cube createCube(Point first, Point second) throws ShapeException {
        return new Cube(first, second);
    }

    public static Cube createCube(Point[] points) throws ShapeException {
        if (points.length != POINTS_AMOUNT) {
            throw new ShapeException("Expected 2 points");
        }
        Point first = points[0];
        Point second = points[1];
        return createCube(first, second);
    }

    public static Cube createCube(double[] array) throws ShapeException {
        if (array.length != ARRAY_LENGTH) {
            throw new ShapeException("Expected array of length 6");
        }
        Point first = new Point(array[0], array[1], array[2]);
        Point second = new Point(array[3], array[4], array[5]);
        return createCube(first, second);
    }
    // TODO: 03.05.2021 add validation 
}
