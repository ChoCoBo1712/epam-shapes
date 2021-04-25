package com.chocobo.shapes.service.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.service.CubeCalculationService;
import com.chocobo.shapes.validator.CubePointsValidator;

public class CubeCalculationServiceImpl implements CubeCalculationService {

    @Override
    public double findPerimeter(Cube cube) throws ShapeException {
        if (cube == null) {
            throw new ShapeException("Argument is null");
        }

        if (!CubePointsValidator.validateCube(cube)) {
            throw new ShapeException("Invalid cube: " + cube.toString());
        }

        double edgeLength = findEdgeLength(cube);
        return edgeLength * 12;
    }

    @Override
    public double findArea(Cube cube) throws ShapeException {
        if (cube == null) {
            throw new ShapeException("Argument is null");
        }

        if (!CubePointsValidator.validateCube(cube)) {
            throw new ShapeException("Invalid cube: " + cube.toString());
        }

        double edgeLength = findEdgeLength(cube);
        return Math.pow(edgeLength, 2) * 6;
    }

    @Override
    public double findVolume(Cube cube) throws ShapeException {
        if (cube == null) {
            throw new ShapeException("Argument is null");
        }

        if (!CubePointsValidator.validateCube(cube)) {
            throw new ShapeException("Invalid cube: " + cube.toString());
        }

        double edgeLength = findEdgeLength(cube);
        return  Math.pow(edgeLength, 3);
    }

    private double findEdgeLength(Cube cube) {
        Point first = cube.getFirstPoint();
        Point second = cube.getSecondPoint();
        return Math.abs(first.getZ() - second.getZ());
    }
}
