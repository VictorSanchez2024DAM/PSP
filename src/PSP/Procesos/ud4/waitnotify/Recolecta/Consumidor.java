package PSP.Procesos.ud4.waitnotify.Recolecta;

import java.util.Random;

public class Consumidor implements Runnable {
    private Recolecta recolecta;

    public Consumidor(Recolecta recolecta) {
        this.recolecta = recolecta;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(true){
            int num = r.nextInt(100, 400+1);
            int ms = r.nextInt(20, 300+1);

            recolecta.extraerDinero(num, ms);
        }



    }
}
