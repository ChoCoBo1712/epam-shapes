package com.chocobo.shapes.validator;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;

public class CubePointsValidator {

    public static boolean validatePoints(Point first, Point second) {
        if (first == null || second == null) {
            return false;
        }

        boolean result = Double.compare(first.getX(), second.getX()) == 0;
        result &= Double.compare(first.getY(), second.getY()) == 0;
        result &= Double.compare(first.getZ(), second.getZ()) > 0;
        return result;
    }

    public static boolean validateCube(Cube cube) {
        return validatePoints(cube.getFirstPoint(), cube.getSecondPoint());
    }
}
