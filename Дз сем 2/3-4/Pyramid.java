package com.company;

public class Pyramid extends Shape{
    private double s;
    private double h;
    public Pyramid(double s, double h){
        this.s = s;
        this.h = h;
        setVolume((this.s * this.h)/3);
    }
}
