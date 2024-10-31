package PSP.Procesos.ud3;

import java.util.concurrent.TimeUnit;

public class ThreadOne extends Thread{
    @Override
    public void run() {
        System.out.println("Soy el hilo uno");
        for (int i = 0; i < 10; i++) {
            System.out.println(" 9 ");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                System.err.println("Error...");
            }

        }
    }
}
