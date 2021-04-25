package com.chocobo.shapes.comparator;

import com.chocobo.shapes.entity.Cube;

import java.util.Comparator;

public class CubeIdComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube firstCube, Cube secondCube) {
        long firstId = firstCube.getCubeId();
        long secondId = secondCube.getCubeId();
        return Long.compare(firstId, secondId);
    }
}
