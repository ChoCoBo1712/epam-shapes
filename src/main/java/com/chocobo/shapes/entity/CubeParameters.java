package com.chocobo.shapes.entity;

public class CubeParameters {

    private double perimeter;
    private double area;
    private double volume;

    public CubeParameters(double perimeter, double area, double volume) {
        this.perimeter = perimeter;
        this.area = area;
        this.volume = volume;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        CubeParameters parameters = (CubeParameters) object;
        boolean result = perimeter == parameters.perimeter;
        result &= area == parameters.area;
        result &= volume == parameters.volume;
        return result;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 7;

        result = result * prime + Double.hashCode(perimeter);
        result = result * prime + Double.hashCode(area);
        result = result * prime + Double.hashCode(volume);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("perimeter: ").append(perimeter);
        stringBuilder.append(", area: ").append(area);
        stringBuilder.append(", volume: ").append(volume);
        stringBuilder.append(";");
        return stringBuilder.toString();
    }
}
