package com.chocobo.shapes.comparator;

import com.chocobo.shapes.entity.Cube;

import java.util.Comparator;

public class SecondPointYComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube firstCube, Cube secondCube) {
        double firstY = firstCube.getSecondPoint().getY();
        double secondY = secondCube.getSecondPoint().getY();
        return Double.compare(firstY, secondY);
    }
}
