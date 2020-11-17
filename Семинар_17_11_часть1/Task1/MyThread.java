package Task1;

public class MyThread extends Thread{
    private Object object;

    MyThread(String name, Object object){
        super(name);
        this.object = object;
    }

    public void go() {
        for (int i=1; i<8; i++){
            object.add();
            object.show();
            System.out.println(getState());
        }
    }
}
