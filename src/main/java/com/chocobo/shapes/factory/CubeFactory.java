package com.chocobo.shapes.factory;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.validator.CubePointsValidator;

public class CubeFactory {

    public static final int ARRAY_LENGTH = 6;

    private CubeFactory() { }

    public static Cube createCube(Point first, Point second) throws ShapeException {
        Cube cube = new Cube(first, second);
        if (!CubePointsValidator.isValidCube(cube)) {
            throw new ShapeException("Invalid cube: " + cube);
        }
        return cube;
    }

    public static Cube createCube(
            double firstX, double firstY, double firstZ,
            double secondX, double secondY, double secondZ
    ) throws ShapeException {
        Point first = new Point(firstX, firstY, firstZ);
        Point second = new Point(secondX, secondY, secondZ);
        return createCube(first, second);
    }
}
