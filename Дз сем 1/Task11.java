package com.company;

public class Task11 {
    private int a;
    private int b;
    public Task11(int a, int b){
        this.a = a;
        this.b = b;
    }
    public double GMedium(){
        double gmed = a*b;
        return Math.sqrt(gmed);
    }
}