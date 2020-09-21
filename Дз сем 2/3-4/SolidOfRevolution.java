package com.company;

public abstract class SolidOfRevolution  extends Shape{
    private double radius;

    public SolidOfRevolution(double r){
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }
}
