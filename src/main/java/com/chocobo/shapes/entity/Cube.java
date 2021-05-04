package com.chocobo.shapes.entity;

import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.observer.CubeEvent;
import com.chocobo.shapes.observer.CubeObservable;
import com.chocobo.shapes.observer.CubeObserver;
import com.chocobo.shapes.util.CubeIdGenerator;

public class Cube implements Cloneable, CubeObservable {

    private final long cubeId;
    private Point firstPoint;
    private Point secondPoint;

    private CubeObserver observer = null;

    public Cube(Point firstPoint, Point secondPoint) throws ShapeException {
        if (firstPoint == null || secondPoint == null) {
            throw new ShapeException("Attempt to create cube with null arguments");
        }

        this.cubeId = CubeIdGenerator.generateId();
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public long getCubeId() {
        return cubeId;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) throws ShapeException {
        if (firstPoint == null) {
            throw new ShapeException("Argument is null");
        }

        this.firstPoint = firstPoint;
        notifyObserver();
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) throws ShapeException {
        if (secondPoint == null) {
            throw new ShapeException("Argument is null");
        }

        this.secondPoint = secondPoint;
        notifyObserver();
    }

    public boolean contentEquals(Cube cube) {
        if (cube == this) {
            return true;
        }

        if (cube == null) {
            return false;
        }

        boolean result = firstPoint.equals(cube.firstPoint);
        result &= secondPoint.equals(cube.secondPoint);
        return result;
    }

    @Override
    public void attachObserver(CubeObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detachObserver() {
        observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.parametersChanged(new CubeEvent(this));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Cube cube = (Cube) object;
        boolean result = cubeId == cube.cubeId;
        result &= firstPoint.equals(cube.firstPoint);
        result &= secondPoint.equals(cube.secondPoint);
        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 7;

        result = result * prime + firstPoint.hashCode();
        result = result * prime + secondPoint.hashCode();

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Cube: ");
        stringBuilder.append("cubeId = ").append(cubeId);
        stringBuilder.append(", [first point: ").append(firstPoint);
        stringBuilder.append(", second point: ").append(secondPoint);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Cube clone() {
        Cube cube = null;
        try {
            cube = (Cube) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cube;
    }
}
