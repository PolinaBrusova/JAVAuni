package com.company;

public class Main_BoxShape {
    public static void main(String[] args) {
        Box box = new Box(150);
        boolean result;

        Pyramid pyramid = new Pyramid(20,3);
        result = box.add(pyramid);
        if (result) {
            System.out.println("Не заполнено единиц объема: " + box.getVolume());
        }
        else System.out.println("Для этой фигуры в коробке не хватает места");

        Ball ball = new Ball(3);
        result = box.add(ball);
        if (result) {
            System.out.println("Не заполнено единиц объема: " + box.getVolume());
        }
        else System.out.println("Для этой фигуры в коробке не хватает места");

        Cylinder cylinder = new Cylinder(2, 2);
        result = box.add(cylinder);
        if (result) {
            System.out.println("Не заполнено единиц объема: " + box.getVolume());
        }
        else System.out.println("Для этой фигуры в коробке не хватает места");
    }
}
