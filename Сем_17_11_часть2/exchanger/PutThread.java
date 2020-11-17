package exchanger;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable{
    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger<String> ex){
        this.exchanger = ex;
        message = "Hello JAVA";
    }

    @Override
    public void run() {
        try{
            message = exchanger.exchange(message);
            System.out.println("PutThread " + message);
        }catch (InterruptedException e){
            System.out.println("PutThread " + message);
        }
    }
}
