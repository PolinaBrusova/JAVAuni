package com.company;

public class Task4 {
    public static void main(String[] args){
        //способ 1
        int x = 10;
        int y = 12;
        System.out.println("Было x="+x+", y="+y);
        int t = x;
        x = y;
        y = t;
        System.out.println("Стало x="+x+", y="+y);
        //способ 2
        int a = 100;
        int b = 1;
        System.out.println("Было a="+a+", b="+b);
        a = a + b - (b = a);
        System.out.println("Стало a="+a+", b="+b);
    }
}
