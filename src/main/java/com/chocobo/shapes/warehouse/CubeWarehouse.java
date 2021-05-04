package com.chocobo.shapes.warehouse;

import com.chocobo.shapes.entity.CubeParameter;
import com.chocobo.shapes.exception.ShapeException;

import java.util.Optional;

public interface CubeWarehouse {
    Optional<CubeParameter> get(long id);
    void put(long id, double perimeter, double area, double volume);
    void remove(Long id) throws ShapeException;
}
