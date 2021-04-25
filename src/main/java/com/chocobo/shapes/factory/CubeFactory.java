package com.chocobo.shapes.factory;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;

public class CubeFactory {

    private CubeFactory() { }

    public static Cube createCube(Point first, Point second) throws ShapeException {
        return new Cube(first, second);
    }
}
