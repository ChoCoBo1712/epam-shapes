package com.chocobo.shapes.repository.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.repository.Specification;

public class CubeEdgeSizeSpecification implements Specification {

    private final double size;

    public CubeEdgeSizeSpecification(double size) {
        this.size = size;
    }

    @Override
    public boolean specify(Cube cube) {
        if (cube == null) {
            return false;
        }

        double edgeSize = cube.getFirstPoint().getZ() - cube.getSecondPoint().getZ();
        return edgeSize >= size;
    }
}
