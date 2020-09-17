package com.company;

public class Task12 {
    private double a;
    private double b;
    private double c;
    private double d;
    public Task12(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public double Way(){
        double stage1 = (c - a)*(c - a);
        double stage2 = (d - b)*(d - b);
        return Math.sqrt(stage1+stage2);
    }
}
