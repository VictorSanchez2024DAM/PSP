package PSP.Procesos.ud4.ej1;

import PSP.Procesos.ud4.ThreadColor;

import java.util.Random;

public class Marcador {

    private static final int minRange = 1;
    private static final int maxRange = 10;
    private static final int maxLaps = 3;
    private int puntosTotales = 0;

    public Marcador() {
    }

    public void agregarPuntos(int puntos){
        String threadName = Thread.currentThread().getName();
        ThreadColor enumColor = ThreadColor.valueOf(threadName);

        if(puntosTotales <= 50){
            System.out.println(enumColor.color() + puntosTotales + " " + " " + puntos);
            puntosTotales += puntos;
            System.out.println(enumColor.color() + puntosTotales);
        } else{
            System.out.println("Has alcanzado la meta");
        }
    }
    public void agregarPuntos(){
        for (int i = 0; i < maxLaps; i++) {
            Random r = new Random();
            int random = r.nextInt(minRange, maxRange + 1);
            agregarPuntos(random);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
