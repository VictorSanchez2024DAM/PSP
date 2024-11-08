package PSP.Procesos.ud4.puente;

public class Puente {
    private static final int PESO_MAXIMO = 200;
    private static final int MAX_PERSONAS = 3;

    private int peso;
    private int numPersonas;


    public synchronized boolean autorizacionPaso(int peso){
        if(this.numPersonas < MAX_PERSONAS &&
                (this.peso + peso) <= PESO_MAXIMO){
            this.numPersonas++;
            this.peso+= peso;
            return true;
        }
        return false;
    }

    public synchronized void terminaPaso(int peso){
        this.peso-= peso;
        this.numPersonas--;
    }

}
