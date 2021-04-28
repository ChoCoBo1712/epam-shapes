package com.chocobo.shapes.repository.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.repository.Specification;

public class CubeIdSpecification implements Specification {

    private final long cubeId;

    public CubeIdSpecification(long cubeId) {
        this.cubeId = cubeId;
    }

    @Override
    public boolean specify(Cube cube) {
        if (cube == null) {
            return false;
        }

        return cube.getCubeId() == cubeId;
    }
}
