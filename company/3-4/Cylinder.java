package com.company;

public class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double r, double h) {
        super(r);
        this.height = h;
        setVolume(Math.PI*Math.pow(r, 2)*this.height);
    }
}
