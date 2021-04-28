package com.chocobo.shapes.comparator;

import com.chocobo.shapes.entity.Cube;

import java.util.Comparator;

public enum CubeComparator implements Comparator<Cube> {

    ID {
        @Override
        public int compare(Cube firstCube, Cube secondCube) {
            long firstId = firstCube.getCubeId();
            long secondId = secondCube.getCubeId();
            return Long.compare(firstId, secondId);
        }
    },
    FIRST_POINT_X {
        @Override
        public int compare(Cube firstCube, Cube secondCube) {
            double firstX = firstCube.getFirstPoint().getX();
            double secondX = secondCube.getFirstPoint().getX();
            return Double.compare(firstX, secondX);
        }
    },
    FIRST_POINT_Y {
        @Override
        public int compare(Cube firstCube, Cube secondCube) {
            double firstY = firstCube.getFirstPoint().getY();
            double secondY = secondCube.getFirstPoint().getY();
            return Double.compare(firstY, secondY);
        }
    },
    SECOND_POINT_X {
        @Override
        public int compare(Cube firstCube, Cube secondCube) {
            double firstX = firstCube.getSecondPoint().getX();
            double secondX = secondCube.getSecondPoint().getX();
            return Double.compare(firstX, secondX);
        }
    },
    SECOND_POINT_Y {
        @Override
        public int compare(Cube firstCube, Cube secondCube) {
            double firstY = firstCube.getSecondPoint().getY();
            double secondY = secondCube.getSecondPoint().getY();
            return Double.compare(firstY, secondY);
        }
    }
}
