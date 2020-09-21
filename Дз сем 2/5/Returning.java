package com.company;


class Returning {
    int[] values;
    int[] scales;
    int[] weight;
    int summa = 0;

    public Returning(int[] values, int[] scales) {

        this.values = values;
        this.weight = new int[values.length];
        this.scales = scales;

        summa = 0;

        for(int i = 0; i < scales.length; i++) {
            summa += scales[i];
        }

        int s = 0;
        for (int i = 0; i < weight.length; i++) {
            weight[i] = s;
            s += scales[i];
        }
    }


    public int Number() {
        int random = (int) (Math.random() * (summa - 1));
        int test = 0;

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] > random)
                break;
            test = i;
        }

        return values[test];
    }
}
