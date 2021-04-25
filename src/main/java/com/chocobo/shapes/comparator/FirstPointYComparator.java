package com.chocobo.shapes.comparator;

import com.chocobo.shapes.entity.Cube;

import java.util.Comparator;

public class FirstPointYComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube firstCube, Cube secondCube) {
        double firstY = firstCube.getFirstPoint().getY();
        double secondY = secondCube.getFirstPoint().getY();
        return Double.compare(firstY, secondY);
    }
}
