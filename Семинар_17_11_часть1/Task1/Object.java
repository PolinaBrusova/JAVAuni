package Task1;

public class Object {
    private int checking = 0;

    public synchronized void add() {
        if (checking > 5) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        checking++;
        notifyAll();
    }

    public synchronized void show(){
        System.out.println(checking);
    }
}
