package com.company;

public class Main_for_1_2 {

    public static void main(String[] args) {
        //Формируем матрицу 1
        int [][] m1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        //Формируем матрицу 2
        int [][] m2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        //Тестовая кривая матрица
        int [][] m3 = {
                {1,2},
                {1,2,3,4},
                {7}
        };
        //Примеры работы класса матриц
        Matrix matrix1 = new Matrix(m1);
        Matrix summa = matrix1.Summary(m2);
        summa.Screen();
        Matrix diff = matrix1.Difference(m3);
        diff.Screen();
        Matrix mulNum = matrix1.MultNum(6);
        mulNum.Screen();
        Matrix multy = matrix1.Multiply(m2);
        multy.Screen();
        Matrix tran = matrix1.Transp();
        tran.Screen();
        Matrix pows = matrix1.MPow(5);
        pows.Screen();
        //Примеры работа класса векторов
        System.out.println("--------------------------");
        Vector v1 = new Vector(-1,4,3);
        Vector v2 = new Vector(5,-1,0);
        double l1 = v1.length();
        System.out.println(l1);
        double mult = v1.ScMult(v2);
        System.out.println(mult);
        Vector vmult = v1.VecMult(v2);
        vmult.Scan();
        double cosinus = v1.AngleCos(v2);
        System.out.println(cosinus);
        Vector sum = v1.Summa(v2);
        sum.Scan();
        Vector dif = v1.Diff(v2);
        dif.Scan();
        Vector[] rows = Vector.Rand(7);
        for (Vector row : rows) {
            row.Scan();
        }
    }
}
