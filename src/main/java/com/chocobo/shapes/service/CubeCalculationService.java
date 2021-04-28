package com.chocobo.shapes.service;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.exception.ShapeException;

public interface CubeCalculationService {

    double calculatePerimeter(Cube cube) throws ShapeException;
    double calculateArea(Cube cube) throws ShapeException;
    double calculateVolume(Cube cube) throws  ShapeException;
}
