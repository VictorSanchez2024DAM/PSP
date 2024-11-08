package PSP.Procesos.ud4.waitnotify;

import java.util.Random;

public class Escritor implements Runnable{

    private MessageRepository repository;

    public Escritor (MessageRepository repository){
        this.repository = repository;
    }

    @Override
    public void run() {
    String [] messages = {
            "Buenas tardes",
            "Estoy en clase",
            "PSP",
            "Viva la huelga"
    };
    Random random = new Random();
        for (int i = 0; i < messages.length ; i++) {
            repository.write(messages[i]);
            System.out.println("Escribo mensaje");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Error...");
            }
        }
        repository.write("EOF");
    }
}
