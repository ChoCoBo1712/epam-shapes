package com.chocobo.shapes.comparator;

import com.chocobo.shapes.entity.Cube;

import java.util.Comparator;

public class FirstPointXComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube firstCube, Cube secondCube) {
        double firstX = firstCube.getFirstPoint().getX();
        double secondX = secondCube.getFirstPoint().getX();
        return Double.compare(firstX, secondX);
    }
}
