package PSP.Procesos.ud4.waitnotify;

/**
 * Metodos que solo se pueden usar en espacios sincronizados
 * wait, notify y notifyAll
 * Apps consumer/producer --> hilos que produzcan cosas
 * --> hilos que las consuman
 */
public class MessageRepository {

    private String message;
    private boolean hasMessage;

    public synchronized String read(){
            while(!hasMessage){
                try{
                    wait();
                } catch (InterruptedException e){
                    System.err.println("Error...");
                }
            }
            hasMessage = false;
            notify();
            return message;


    }

    public synchronized void write(String message){
        while(hasMessage){
            try{
                wait();
            } catch (InterruptedException e){
                System.err.println("Error...");
            }
        }
        hasMessage = true;
        notify();
        this.message = message;
    }

    public MessageRepository(){

    }
}
