package com.chocobo.shapes.service;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.exception.ShapeException;

public interface CubeCalculationService {

    double findPerimeter(Cube cube) throws ShapeException;
    double findArea(Cube cube) throws ShapeException;
    double findVolume(Cube cube) throws  ShapeException;
}
