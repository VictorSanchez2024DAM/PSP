package PSP.Procesos.ud4.puente;

import java.sql.SQLOutput;
import java.util.Random;

public class Persona implements Runnable{

    private final Puente puente;
    private final int peso;
    private final int id;

    public Persona(Puente puente, int peso, int id){
        this.puente = puente;
        this.peso = peso;
        this.id = id;
    }

    @Override
    public void run() {
        Random r = new Random();
        System.out.println("La persona " + this.id + " quiere cruzar el puente con peso " + this.peso);

        synchronized (puente){
            while(!this.puente.autorizacionPaso(this.peso)){
                try {
                    System.out.println("Espere para pasar el puente...");
                    this.puente.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Ahora puedo cruzar el puente");
        try {
            Thread.sleep(r.nextInt(10000, 20000+1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this.puente){
            this.puente.terminaPaso(peso);
            this.puente.notifyAll();
        }
    }
}
