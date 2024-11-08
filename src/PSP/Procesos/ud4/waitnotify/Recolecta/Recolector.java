package PSP.Procesos.ud4.waitnotify.Recolecta;

import java.util.Random;

public class Recolector implements Runnable{
    private Recolecta recolecta;

    public Recolector(Recolecta recolecta) {
        this.recolecta = recolecta;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(true){

            int num = r.nextInt(100, 500+1);
            int ms = r.nextInt(20, 300+1);
            recolecta.insertarDinero(num, ms);
        }



    }
}
