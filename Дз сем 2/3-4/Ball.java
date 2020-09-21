package com.company;

public class Ball extends SolidOfRevolution{
    public Ball(double r){
        super(r);
        setVolume((4*Math.PI*Math.pow(r, 3))/3);
    }
}
