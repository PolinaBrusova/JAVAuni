package exchanger;

import java.util.concurrent.Exchanger;

public class getTread implements Runnable{
    Exchanger<String> exchanger;
    String message;

    getTread(Exchanger<String> ex){
        this.exchanger = ex;
        message = "Hello world";
    }

    @Override
    public void run() {
        try{
            message = exchanger.exchange(message);
            System.out.println("getTread " + message);
        }catch (InterruptedException e){
            System.out.println("getTread " + message);
        }
    }
}
