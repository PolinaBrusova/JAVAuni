package com.company;

public class Task8 {
    public static void main(String[] args){
        int a = 10857485;
        int counter = 0;
        while (a>0){
            a = a/10;
            counter++;
        }
        System.out.println(counter);
    }
}
