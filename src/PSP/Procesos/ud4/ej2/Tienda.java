package PSP.Procesos.ud4.ej2;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private int totalVentas;
    private int totalTransacciones;
    private List<Integer> ultimasTransacciones;

    private final static Object lockTotalVentas = new Object();
    private final static Object lockUltimasTransacciones = new Object();

    public Tienda(int totalVentas) {
        this.totalVentas = totalVentas;
        this.totalTransacciones = 0;
        this.ultimasTransacciones = new ArrayList<>();
    }

    public int getTotalVentas() {
        return this.totalVentas;
    }

    public int getTotalTransacciones() {
        return this.totalTransacciones;
    }

    public List<Integer> getUltimasTransacciones() {
        return ultimasTransacciones;
    }

    public void agregarVenta(int venta){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
        synchronized (lockTotalVentas){
            this.totalVentas += venta;
            System.out.println("Ventas que se van a añadir: " + venta + "\n"
            + "Total ventas al añadirse: " + this.totalVentas);
            this.totalTransacciones++;
        }
        synchronized (lockUltimasTransacciones){
            if(ultimasTransacciones.size() <= 3){
                ultimasTransacciones.add(venta);
            }else{
                ultimasTransacciones.add(2, ultimasTransacciones.get(1));
                ultimasTransacciones.add(1, ultimasTransacciones.get(0));
                ultimasTransacciones.add(0, venta);
            }
        }
    }

    public void aplicarDescuento(int descuento){
        try {
            System.out.println("Procesando el descuento..");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
        synchronized (lockTotalVentas){
            this.totalVentas-= descuento;
            System.out.println("Ventas que se van a descontar: " + descuento + "\n"
                    + "Total ventas al descontarse: " + this.totalVentas);
        }
    }
}
