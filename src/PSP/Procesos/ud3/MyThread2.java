package PSP.Procesos.ud3;

import java.util.concurrent.TimeUnit;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(" 5 ");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Error...");
            }
        }
    }
}
