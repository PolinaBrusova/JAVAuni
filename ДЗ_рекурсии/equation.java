package ДЗ_рекурсии;

public class equation {
    public static double func(double x){
        return 40 - 5 * x;
    }
    public static void print(){
        System.out.println("Уравнение вида: 40 - 5*x ");
    }
    public static double solve(double start, double end){
        double x = start + (end - start) / 2; //делим отрезок пополам
        if(end - start <= 0.001){ //точность
            return start;
        }
        if(func(start) * func(x) > 0){
            //Идем направо
            return solve(x, end);
        } else {
            //Идем налево
            return solve(start, x);
        }
    }
}
