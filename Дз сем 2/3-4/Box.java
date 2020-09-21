package com.company;

public class Box extends Shape {
    public Box(double v){
        setVolume(v);

    }

    public boolean add(Shape shape) {
        if (this.getVolume() < shape.getVolume()){
            return false;
        }
        else{
            double Valid = this.getVolume()- shape.getVolume();
            this.setVolume(Valid);
            return true;

        }
    }
}
