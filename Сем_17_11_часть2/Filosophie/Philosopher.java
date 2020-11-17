package Filosophie;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    Semaphore sem;
    int dishes = 0;
    int philosoph;

    Philosopher(Semaphore sem, int id_phil)
    {
        this.sem=sem;
        this.philosoph=id_phil;
    }

    public void run() {
        try {
            while(dishes<2){// пока количество приемов пищи человека не достигнет 1

                sem.acquire();
                System.out.println ("Философ " + philosoph+" сел");
                sleep(500);
                dishes++;

                System.out.println ("Философ " + philosoph+" встал");
                sem.release();
                sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println ("у философа " + philosoph + " что-то пошло не так");
        }
    }
}
