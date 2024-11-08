package PSP.Procesos.ud4.puente;

import java.util.Random;

/**
 * EL PUENTE
 * El siguiente programa simula un sistema que ocntrola el paso de personas por un puentre,
 * siempre en la misma dirección, para que se cumplan las restricciones:
 * No pueden pasar más de tres personas a la vez, y no puede haber más de 200kg de peso en ningún momento
 *
 * Para realizar la simulación, se modelan las personas como hilos.
 * El tiempo entre la llegada de dos personas al puente es aleatorio entre 1 y 5 segundos.
 * Y el tiempo para atravesar es aleatorio, entre 10 y 20 segundos, tiempo en cruzar el puente.
 * Las personas tendrán un peso aleatorio entre 40 y 120 kg.
 *
 * Tendremos que crear una clase puente. El objeto puente guarda el estado compartido por todos
 * los hilos: peso y num. personas. Este objeto se pasará a todos los hilos de la clase Persona, por el constructor.
 * Puente tendrá un método llamado autorizacionPaso que verifica si se cumplen las condiciones para que a una persona se le
 * conceda permiso para pasar
 * Método llamado terminaPaso que quitar a la persona de ese puente
 */
public class MainPuente {
    public static void main(String[] args) {
        final Puente puente = new Puente();
        Random r = new Random();
        int id = 1;
        while(true){
            try {
                Thread.sleep(r.nextInt(1000, 5000+1000));
            } catch (InterruptedException e) {
                System.err.println("Error, se ha interrumpido la ejecucion...");
            }

            Thread persona = new Thread(new Persona(puente, r.nextInt(40, 120+1), id));
            id++;
        }
    }
}
