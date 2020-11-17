package Task1_2;

public class ThreadTask2 extends Thread{
    private Object lock;

    public ThreadTask2(Object object){
        lock = object;
    }

    public  void run(){
        synchronized (lock){
            try{
                System.out.println(getName());
                lock.notify();
                lock.wait();
            } catch (InterruptedException e) {}
            lock.notify();
        }
    }
}
