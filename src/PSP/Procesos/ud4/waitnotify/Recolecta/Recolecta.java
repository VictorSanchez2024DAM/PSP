package PSP.Procesos.ud4.waitnotify.Recolecta;

public class Recolecta {

    private int dineroTotal;

    public synchronized void insertarDinero(int num, int ms){
        while((dineroTotal + num) > 2000){
            System.out.println("Soy el recolector, no puedo recolectar más dinero");
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error...");
            }
        }
        dineroTotal+= num;
        System.out.println("He recolectado: " + num + " tengo " + dineroTotal);
        notifyAll();
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
    }

    public synchronized void extraerDinero(int num, int ms){
        while(num > dineroTotal){
            System.out.println("Soy hilo consumidor no puedo sacar más dinero");
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error..");
            }
        }
        dineroTotal-= num;
        System.out.println("He consumido: " + num + " me quedan " + dineroTotal);
        notifyAll();
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }

    }


    public Recolecta() {
    }
}


