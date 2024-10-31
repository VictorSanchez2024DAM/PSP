package PSP.Procesos.ud3;

import java.util.concurrent.TimeUnit;

/*
Process --> crea uno o + hilos, como minimo 1 hilo main thread
Todos los hilos comparten el mismo espacio de memoria del proceso
Thread -->
 */

/**
 * Creamos un hilo. este hilo va a imprimir un contador de 0 a 100
 * Y lo llamo desde el hilo principal
 */

/**
 * Crea 3 hilos de diferente forma, Unir 2 hilos al otro que queda, es decir, hasta que no acabe ese hilo
 * no empezara a ejecutar esos dos hilos. Muestra la ejecucion del programa
 */


public class CustomThread {
    public static void main(String[] args) {
        var thread = Thread.currentThread();
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread.getName());

        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 3; i++) {
            System.out.println(" 0 ");

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("error...");
            }

        }

        Runnable r = () -> {
            for (int i = 0; i < 8; i++) {
                System.out.println(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Error...");
                }
            }
        };
        Thread h1 = new Thread(r);
        h1.start();

        Thread h2 = new Thread(new MyThread2());
        h2.start();

        Thread h3 = new Thread(new CountThread());
        h3.setName("CountThread");
        h3.start();

        h3.interrupt();

    }

    public static void printThreadState(Thread thread){
        System.out.println("----------------");
        System.out.println(thread.threadId());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getState());
        System.out.println(thread.isAlive());
        System.out.println("----------------");
    }

}
