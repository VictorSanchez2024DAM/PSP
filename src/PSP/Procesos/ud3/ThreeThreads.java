package PSP.Procesos.ud3;

import java.util.concurrent.TimeUnit;

public class ThreeThreads {
    public static void main(String[] args) {
        Runnable r3 = () -> {
            System.out.println("Soy el tercer hilo");
            for (int i = 0; i < 20; i++) {
                System.out.println(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Error...");
                }
            }
        };

        ThreadOne threadOne = new ThreadOne();
        Thread threadTwo = new Thread(new ThreadTwo(threadOne));
        Thread threadThree = new Thread(r3);
        threadOne.start();

        threadTwo.start();
        threadThree.start();





    }
}
