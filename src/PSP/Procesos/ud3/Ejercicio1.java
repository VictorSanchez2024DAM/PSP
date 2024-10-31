package PSP.Procesos.ud3;

import java.util.concurrent.TimeUnit;

public class Ejercicio1 {
    public static void main(String[] args) {
     //   ej1();

      //  ej2();

        // ej3();

       // ej4();

        // ej5();

        // ej6();


    }

    private static void ej6() {
        // 6
        Thread thread12 = new Thread(() ->{
                try {
                    for (int i = 1; i > 0 ; i++) {
                        System.out.println("Soy infinito");
                        TimeUnit.SECONDS.sleep(1);
                    }

                } catch (InterruptedException e) {
                    System.err.println("Hilo 12 : Interrumpido");
                }


        });

        Thread thread13 = new Thread(() -> {
            try {
                thread12.join();
                System.out.println("Soy el hilo 13");
            } catch (InterruptedException e) {
                System.err.println("Hilo 13 : Interrumpido");
            }
        });

        Thread thread14 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                thread12.interrupt();
            } catch (InterruptedException e) {
                System.err.println("Hilo 14 : Interrumpido");
            }

        });
        thread12.start();
        thread13.start();
        thread14.start();
    }

    private static void ej5() {
        // 5
        Thread thread10 = new Thread(() -> {
            try{
                for (int i = 1; i < 6; i++) {
                    System.out.println("Soy el hilo 10");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e){
                System.err.println("Hilo 10: Interrumpido");
            }
        });
        Thread thread11 = new Thread(() -> {
            try{
                thread10.join();
                for (int i = 6; i < 11; i++) {
                    System.out.println("Soy el hilo 11");
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException e){
                System.err.println("Hilo 11: Interrumpido");
            }
        });

        thread10.start();
        thread11.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            thread10.interrupt();
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
    }

    private static void ej4() {
        // 4
        ThreadEj4 thread8 = new ThreadEj4();

        Runnable r1 = () -> {
            try {
                thread8.join();
                System.out.println("Suma realizada con extio");
            } catch (InterruptedException e) {
                System.err.println("Hilo 9: Interrumpido");
            }
        };
        Thread thread9 = new Thread(r1);

        thread8.start();
        thread9.start();
    }

    private static void ej3() {
        // 3
        Thread thread6 = new Thread(() -> {
            try{
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hola");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e){
                System.err.println("Hilo 6: Interrumpido");
            }
        });

        Thread thread7 = new Thread(() -> {
            try{
                while(thread6.isAlive()) {
                    System.out.println("El hilo 6 esta vivo");
                    TimeUnit.SECONDS.sleep(2);
                }
                System.out.println("El hilo 6 ha muerto");

            } catch (InterruptedException e){
                System.err.println("Hilo 7: Interrumpido");
            }
        });

        thread6.start();
        thread7.start();
    }

    private static void ej2() {
        // 2
        Thread thread3 = new Thread(() -> {
            try{
                for (int i = 1; i < 6; i++) {
                    System.out.println(i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e){
                System.err.println("Hilo 3: Interrumpido");
            }
        });
        Thread thread4 = new Thread(() -> {
            try{
                thread3.join();
                for (int i = 6; i < 11; i++) {
                    System.out.println(i);
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException e){
                System.err.println("Hilo 4: Interrumpido");
            }
        });
        Thread thread5 = new Thread(() -> {
            try{
                thread4.join();
                for (int i = 11; i < 16; i++) {
                    System.out.println(i);
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException e){
                System.err.println("Hilo 5: Interrumpido");
            }
        });
        thread3.start();
        thread4.start();
        thread5.start();
    }

    private static void ej1() {
        // 1
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Hilo 1: Esperando 10 segundos");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Hilo 1: Pasaron 10 segundos");
            } catch (InterruptedException e) {
                System.out.println("Hilo 1: Interrumpido");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Hilo 2: Esperando 3 segundos");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Hilo 2: Interrumpiendo al Hilo 1.");
                thread1.interrupt();
            } catch (InterruptedException e) {
                System.out.println("Hilo 2: Interrumpido");
            }
        });

        thread1.start();
        thread2.start();
    }
}

