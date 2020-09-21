package com.company;
//сделать проверку для сложения и вычитания, чтобы матрицы были одинаковыми!

public class Matrix {
    private int[][] matrix;

    public Matrix(int [][] matrix){
        this.matrix = matrix;
    }

    public void Screen(){
        System.out.println("--------------------------");
        if (matrix.length == 0){
            System.out.println("Решение невозможно");
        }
        else{
            for (int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[i].length; j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    public com.company.Matrix Summary(int [][] matrix2){
        boolean flag = true;
        if (matrix.length == matrix2.length) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length != matrix2[i].length){
                    flag = false;
                }
            }
        }
        int ans [][] = new int [matrix.length][matrix.length];
        if (flag) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    ans[i][j] = matrix[i][j] + matrix2[i][j];
                }
            }
            Matrix answer = new Matrix(ans);
            return answer;
        }
        else{
            int [][] answer = new int[0][0];
            return new Matrix(answer);
        }


    }

    public  com.company.Matrix Difference(int [][] matrix2){
        boolean flag = true;
        if (matrix.length == matrix2.length) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length != matrix2[i].length){
                    flag = false;
                }
            }
        }
        int ans [][] = new int [matrix.length][matrix.length];
        if (flag) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    ans[i][j] = matrix[i][j] - matrix2[i][j];
                }
            }
            return new Matrix(ans);
        }
        else {
            ans = new int [0][0];
            return new Matrix(ans);
        }
    }

    public com.company.Matrix MultNum(int num){
        int ans [][] = new int [matrix.length][matrix.length];
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j< matrix[i].length; j++){
                ans [i][j] = matrix[i][j] * num;
            }
        }
        return new Matrix(ans);
    }

    public com.company.Matrix Multiply(int[][] matrix2){
        if (matrix[0].length != matrix2.length){
            int [][] ans = new int [0][0];
            return new Matrix(ans);
        }
        else {
            int ans [][] = new int [matrix[0].length][matrix2.length];
            for (int i=0; i<matrix.length; ++i) {
                for (int j = 0; j < matrix2[0].length; ++j){
                    for (int k = 0; k < matrix2.length; ++k){
                        ans[i][j] += matrix[i][k] * matrix2[k][j];
                    }
                }
            }
            return new Matrix(ans);
        }
    }

    public com.company.Matrix Transp(){
        boolean flag = true;
        int [][] test = new int [0][0];
        int [][] ans = matrix;
        for (int i = 0; i < matrix.length-1; i++){
            if (matrix[i].length != matrix[i+1].length){
                flag = false;
            }
        }
        if (flag) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix.length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            int [][] fin = matrix;
            return new Matrix(fin);
        }
        else{
            return new Matrix(test);
        }
    }
    public com.company.Matrix MPow(int pow){
        boolean flag = true;
        for (int i = 0; i < matrix.length-1; i++){
            if ((matrix[i].length != matrix[i+1].length)|(matrix[i].length != matrix.length)|(matrix[i+1].length != matrix.length)){
                flag = false;
            }
        }
        if (flag){
            int [][] temp = matrix;
            for (int i = 2; i < pow+1; i++){
                Matrix one = new Matrix(matrix);
                one = one.Multiply(temp);
                matrix = one.matrix;
            }
            int [][] ans = matrix;
            return new Matrix(ans);
        }
        else {
            int ans [][] = new int [0][0];
            return new Matrix(ans);
        }
    }
}
