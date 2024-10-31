package PSP.Procesos.ud3;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ThreadEj4 extends Thread{
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");

        int num = sc.nextInt();
        int suma = 0;

        for (int i = 1; i <= num; i++) {
            suma += i;
            System.out.println(suma);
        }
    }
}
