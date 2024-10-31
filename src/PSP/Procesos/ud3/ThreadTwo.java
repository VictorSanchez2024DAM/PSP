package PSP.Procesos.ud3;

import java.util.concurrent.TimeUnit;

public class ThreadTwo implements Runnable{
    private ThreadOne threadOne;
    @Override
    public void run() {
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
        System.out.println("Soy el segundo hilo");
        for (int i = 0; i < 15; i++) {
            System.out.println(" 4 ");
            try {
                TimeUnit.MILLISECONDS.sleep(700);
            } catch (InterruptedException e) {
                System.err.println("Error...");
            }
        }
    }

    public ThreadTwo(ThreadOne threadOne) {
        this.threadOne = threadOne;
    }
}

