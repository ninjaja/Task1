package com.matrizaev.shape.entity;

public class Cube {

    private CenterPoint center;
    private double sideLength;

    public Cube() {
    }

    public Cube(CenterPoint center, double sideLength) {
        this.center = center;
        this.sideLength = sideLength;
    }

    public CenterPoint getCenter() {
        return center;
    }

    public void setCenter(CenterPoint center) {
        this.center = center;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        if (sideLength != cube.sideLength) return false;
        return center != null ? center.equals(cube.center) : cube.center == null;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + Double.valueOf(sideLength).hashCode();
        result = prime * result + (center != null ? center.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cube (center coordinates: x=" + center.getX() + ", y=" + center.getY() + ", z=" + center.getZ() + ", side length: " + getSideLength() +")";
    }
}
