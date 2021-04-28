package com.chocobo.shapes.validator;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubePointsValidator {

    private static final Logger logger = LogManager.getLogger();

    public static boolean isValidCube(Cube cube) {
        Point first = cube.getFirstPoint();
        Point second = cube.getSecondPoint();

        boolean isValid = Double.compare(first.getX(), second.getX()) == 0;
        isValid &= Double.compare(first.getY(), second.getY()) == 0;
        isValid &= Double.compare(first.getZ(), second.getZ()) > 0;
        return isValid;
    }
}
