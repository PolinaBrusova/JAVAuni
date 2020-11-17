package Task1;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        MyThread t = new MyThread("THREAD 1", object);
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        t.go();
        System.out.println(t.getState());
    }
}
