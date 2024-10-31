package PSP.Procesos.ud3;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0 ; i < 5 ; i++){
            System.out.println(" 1 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("error...");
            }
        }
    }
}
