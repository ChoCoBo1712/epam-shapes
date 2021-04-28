package com.chocobo.shapes.warehouse.impl;

import com.chocobo.shapes.entity.CubeParameters;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.warehouse.CubeWarehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CubeWarehouseImpl implements CubeWarehouse {

    private static CubeWarehouse instance = null;
    private final Map<Long, CubeParameters> map;

    private CubeWarehouseImpl() {
        map = new HashMap<>();
    }

    public static CubeWarehouse getInstance() {
        if (instance == null) {
            instance = new CubeWarehouseImpl();
        }

        return instance;
    }

    @Override
    public Optional<CubeParameters> get(Long id) throws ShapeException {
        if (id == null) {
            throw new ShapeException("Id is null");
        }
        CubeParameters parameters = map.get(id);
        return parameters != null ? Optional.of(parameters) : Optional.empty();
    }

    @Override
    public void put(Long id, CubeParameters parameters) throws ShapeException {
        if (id == null) {
            throw new ShapeException("Id is null");
        }

        if (parameters == null) {
            throw new ShapeException("Cube parameters is null");
        }

        map.put(id, parameters);
    }

    @Override
    public void remove(Long id) throws ShapeException {
        if (id == null) {
            throw new ShapeException("Id is null");
        }

        map.remove(id);
    }
}
