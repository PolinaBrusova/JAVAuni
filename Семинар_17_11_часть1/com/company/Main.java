package com.company;

public class Main {

    public static void main(String[] args) {
        /**Thread t = Thread.currentThread();
        System.out.println(t.getName());
        t.setName("ASD");
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        // t.join() ожидает завершиение потока
        // t.start() запуск потока (необходимые действия перед запуском

        // Создание потока - наследование от Thread, либо имплементирование
        System.out.println("Main thread started");
        for (int i=0; i<10; i++){
            new NewThread("thread "+i).start();
        }
        System.out.println("Main thread finished");

        // При запуске потоков главный поток завершается всегда после дочернего
        System.out.println("Main thread started");
        NewThread test = new NewThread("Thread1");
        test.start();
        try {
            t.join();
        }catch (InterruptedException e){
            System.out.println("Thread is interruoted");
        }
        System.out.println("Main thread finished");
        System.out.println("--------------------------------------");
        System.out.println("Main thread started");
        NewThread2 nt = new NewThread2();
        Thread test2 = new Thread(nt, "Thread1");
        Thread test2 = new Thread(() -> {
            System.out.printf("%s started\n", Thread.currentThread().getName());
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                System.out.println("Thread is interrupted");
            }
            System.out.printf("Thread %s is finished\n", Thread.currentThread().getName());
        }, "Thread2")

        test2.start();
        try {
            Thread.sleep(200);
            nt.disable();
            Thread.sleep(200);
        }catch (InterruptedException e){
            System.out.println("Thread is interrupted");
        }
        System.out.println("Main thread finished");

        NewThread nt2 = new NewThread("THREADNEW");
        try {
            Thread.sleep(200);
            nt2.interrupt();
            Thread.sleep(200);
        }catch (InterruptedException e){
            System.out.println("Thread is interrupted");
        }
        System.out.println("Main thread finished");**/


        System.out.println("Main thread started...");
        CommonResurce commonResurce = new CommonResurce();
        for (int i = 1; i<5; i++){
            Thread testt = new Thread(new CountThread(commonResurce), "thread"+i);
            testt.start();
        }
    }
}
