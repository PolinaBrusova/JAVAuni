package ДЗ_рекурсии;

import java.util.concurrent.TimeUnit;

public class force{
        public static double brut_force(double[] array, double key) {
            //Перебираем элементы
            for (int i = 0; i < array.length; i++) {
                if (array[i] == key)
                    return i;
            }
            return -1;
        }

        public static int RecursiveSreach
                (double[] sortedArray, double key, int low, int high) {
            //Ищем в пределах минимума и максимума
            int center = (low + high) / 2;

            if (high <= low) {
                //Если уже не можем поделить
                return -1;
            }

            if (key == sortedArray[center]) {
                return center;
            } else if (key < sortedArray[center]) {
                //Идем налево
                return RecursiveSreach(sortedArray, key, low, center - 1);
            } else {
                //Идем направо
                return RecursiveSreach(sortedArray, key, center + 1, high);
            }
        }
    }
