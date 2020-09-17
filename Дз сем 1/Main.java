package com.company;

public class Main {

    public static void main(String[] args) {
        Task9 task9 = new Task9(23);
        System.out.println(task9.Dec());

        Task10 task10 = new Task10(23, 24);
        System.out.println(task10.Medium());

        Task11 task11 = new Task11(3, 26);
        System.out.println(task11.GMedium());

        Task12 task12 = new Task12(3.0, 4.0, 5.2, 1.6);
        System.out.println(task12.Way());
    }
}
