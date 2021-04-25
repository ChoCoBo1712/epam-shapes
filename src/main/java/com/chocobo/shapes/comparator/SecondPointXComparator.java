package com.chocobo.shapes.comparator;

import com.chocobo.shapes.entity.Cube;

import java.util.Comparator;

public class SecondPointXComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube firstCube, Cube secondCube) {
        double firstX = firstCube.getSecondPoint().getX();
        double secondX = secondCube.getSecondPoint().getX();
        return Double.compare(firstX, secondX);
    }
}
