package Task1_2;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        // Задача 1
        System.out.println("\nЗадача 1 -------------------------");
        java.lang.Object object = new java.lang.Object();
        Thread thread = new Thread("THREAD"){
            @Override
            public void run() {
                System.out.println(getState());
                try {
                    synchronized (object){
                        object.notifyAll();
                        object.wait(3000);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        synchronized (object) {
            System.out.println(thread.getState());
            thread.start();
            object.wait();
            System.out.println(thread.getState());
            object.notifyAll();
            System.out.println(thread.getState());
        }
        try{
            thread.join();
        }catch (InterruptedException e){}
        System.out.println(thread.getState());

        //Задача 2
        System.out.println("\nЗадача 2 -------------------------");
        Object lock = new Object();
        new ThreadTask2(lock).start();
        new ThreadTask2(lock).start();
    }
}
