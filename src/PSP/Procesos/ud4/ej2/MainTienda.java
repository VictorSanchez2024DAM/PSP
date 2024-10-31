package PSP.Procesos.ud4.ej2;

import java.util.Random;

public class MainTienda {
    public static void main(String[] args) {
        final Tienda tienda = new Tienda(0);

        Thread cajero1 = new Cajero(tienda);
        Thread cajero2 = new Cajero(tienda);
        Thread cajero3 = new Cajero(tienda);
        Thread admin = new Thread(() -> tienda.aplicarDescuento(new Random().nextInt(1, 100-1)));

        cajero1.start();
        cajero2.start();
        cajero3.start();
        admin.start();


        try {
            cajero1.join();
            cajero2.join();
            cajero3.join();
            admin.join();
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
        System.out.println("Total ventas de la tienda: " + tienda.getTotalVentas());
        System.out.println("Total de transacciones: " + tienda.getTotalTransacciones());
        System.out.println("Últimas ventas de la tienda: " + tienda.getUltimasTransacciones().toString());
    }
}
