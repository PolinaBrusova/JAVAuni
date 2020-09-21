package com.company;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void Scan(){
        System.out.println("Вектор ("+x+", "+y+", "+z+")");
    }

    public double length(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double ScMult(Vector vector){
        return this.x*vector.x + this.y*vector.y +this.z*vector.z;
    }

    public com.company.Vector VecMult(Vector vector){
        return new Vector(this.y* vector.z-this.z* vector.y, this.z* vector.x-this.x* vector.z,
                this.x* vector.y-this.y* vector.x);
    }

    public double AngleCos(Vector vector){
        return (this.x*vector.x + this.y*vector.y +this.z*vector.z)/
                (Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z)*
                        Math.sqrt(vector.x* vector.x + vector.y*vector.y + vector.z*vector.z));
    }

    public com.company.Vector Summa(Vector vector){
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    public com.company.Vector Diff(Vector vector){
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    public static com.company.Vector [] Rand(int N){
        Vector  [] rows = new Vector [N];
        for (int i=0; i<N; i++){
            //генерируем три случайных числа в диапазоне [-100; 100]
            double c_x = (Math.random()*(101-(-100)))-100;
            double c_y = (Math.random()*(101-(-100)))-100;
            double c_z = (Math.random()*(101-(-100)))-100;
            Vector vector = new Vector(c_x, c_y, c_z);
            rows[i] = vector;
        }
        return rows;
    }
}
