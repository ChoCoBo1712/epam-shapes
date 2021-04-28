package com.chocobo.shapes.entity;

public class Point implements Cloneable {

    private double x;
    private double y;
    private double z;

    public Point() { }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Point point = (Point) object;
        boolean result = x == point.x;
        result &= y == point.y;
        result &= z == point.z;
        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 7;

        result = result * prime + Double.hashCode(x);
        result = result * prime + Double.hashCode(y);
        result = result * prime + Double.hashCode(z);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("x: ").append(x);
        stringBuilder.append(", y: ").append(y);
        stringBuilder.append(", z: ").append(z);
        return stringBuilder.toString();
    }

    @Override
    public Point clone() {
        Point point = null;
        try {
            point = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return point;
    }
}
