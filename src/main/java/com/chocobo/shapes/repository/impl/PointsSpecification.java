package com.chocobo.shapes.repository.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.repository.Specification;

public class PointsSpecification implements Specification {

    private final Point first;
    private final Point second;

    public PointsSpecification(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean specify(Cube cube) {
        if (cube == null) {
            return false;
        }

        if (first == null && second == null) {
            return cube.getFirstPoint() == null && cube.getSecondPoint() == null;
        }

        boolean flag = true;

        if (first != null) {
            flag &= cube.getFirstPoint().equals(first);
        }

        if (second != null) {
            flag &= cube.getSecondPoint().equals(second);
        }

        return flag;
    }
}
