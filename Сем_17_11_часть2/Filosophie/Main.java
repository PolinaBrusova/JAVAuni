package Filosophie;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        //Задача про философов
        Semaphore sem = new Semaphore(2);
        for(int i=1;i<6;i++)
            new Philosopher(sem,i).start();
    }
}
