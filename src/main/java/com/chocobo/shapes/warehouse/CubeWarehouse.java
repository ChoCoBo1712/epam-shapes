package com.chocobo.shapes.warehouse;

import com.chocobo.shapes.entity.CubeParameters;
import com.chocobo.shapes.exception.ShapeException;

import java.util.Optional;

public interface CubeWarehouse {
    Optional<CubeParameters> get(Long id) throws ShapeException;
    void put(Long id, CubeParameters parameters) throws ShapeException;
    void remove(Long id) throws ShapeException;
}
