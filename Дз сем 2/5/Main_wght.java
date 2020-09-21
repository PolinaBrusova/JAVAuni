package com.company;

public class Main_wght {
    public static void main(String[] args) {
        int[] value = {1,2,3};
        int[] scales = {1,2,10};
        Returning check = new Returning(value, scales);
        for(int i = 0; i < 13; i++){
            int one = check.Number();
            System.out.println(one);
        }
    }
}
