package com.chocobo.shapes.service.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.service.CubeCalculationService;
import com.chocobo.shapes.validator.CubePointsValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeCalculationServiceImpl implements CubeCalculationService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public double calculatePerimeter(Cube cube) throws ShapeException {
        if (cube == null) {
            throw new ShapeException("Argument is null");
        }

        if (!CubePointsValidator.isValidCube(cube)) {
            throw new ShapeException("Invalid cube: " + cube);
        }

        double edgeLength = calculateEdgeLength(cube);
        double perimeter = edgeLength * 12;
        logger.info("Calculated perimeter for " + cube + ": " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea(Cube cube) throws ShapeException {
        if (cube == null) {
            throw new ShapeException("Argument is null");
        }

        if (!CubePointsValidator.isValidCube(cube)) {
            throw new ShapeException("Invalid cube: " + cube);
        }

        double edgeLength = calculateEdgeLength(cube);
        double area = Math.pow(edgeLength, 2) * 6;
        logger.info("Calculated perimeter for " + cube + ": " + area);
        return area;
    }

    @Override
    public double calculateVolume(Cube cube) throws ShapeException {
        if (cube == null) {
            throw new ShapeException("Argument is null");
        }

        if (!CubePointsValidator.isValidCube(cube)) {
            throw new ShapeException("Invalid cube: " + cube);
        }

        double edgeLength = calculateEdgeLength(cube);
        double volume = Math.pow(edgeLength, 3);
        logger.info("Calculated perimeter for " + cube + ": " + volume);
        return volume;
    }

    private double calculateEdgeLength(Cube cube) {
        Point first = cube.getFirstPoint();
        Point second = cube.getSecondPoint();
        return Math.abs(first.getZ() - second.getZ());
    }
}
