package PSP.Procesos.ud4.ej2;

import java.util.Random;

public class Cajero extends Thread{
    private Tienda tienda;
    private int[] transacciones;
    private static final int minRange = 1;
    private static final int maxRange = 100;

    public Cajero(Tienda tienda) {
        this.tienda = tienda;
        this.transacciones = new int[3];
        Random r = new Random();
        for (int i = 0; i < transacciones.length ; i++) {
            transacciones[i] = r.nextInt(minRange, maxRange + 1);

        }
    }

    @Override
    public void run() {
        for(int transaccion : transacciones){
            this.tienda.agregarVenta(transaccion);
        }
    }

    public int[] getTransacciones() {
        return this.transacciones;
    }
}
