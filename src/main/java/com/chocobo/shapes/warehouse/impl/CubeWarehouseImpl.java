package com.chocobo.shapes.warehouse.impl;

import com.chocobo.shapes.entity.CubeParameter;
import com.chocobo.shapes.warehouse.CubeWarehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CubeWarehouseImpl implements CubeWarehouse {

    private static CubeWarehouse instance = null;
    private final Map<Long, CubeParameter> map;

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
    public Optional<CubeParameter> get(long id) {
        CubeParameter parameters = map.get(id);
        return parameters != null ? Optional.of(parameters) : Optional.empty();
    }

    @Override
    public void put(long id, double perimeter, double area, double volume) {
        CubeParameter parameter = map.getOrDefault(id, new CubeParameter());
        parameter.setPerimeter(perimeter);
        parameter.setArea(area);
        parameter.setVolume(volume);

        map.put(id, parameter);
    }

    @Override
    public void remove(Long id) {
        map.remove(id);
    }
}
