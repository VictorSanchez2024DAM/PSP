package PSP.Procesos.ud4.waitnotify;

public class Lector implements Runnable{

    private MessageRepository repository;

    public Lector(MessageRepository repository){
        this.repository = repository;
    }

    @Override
    public void run() {
        String lastMessage = "";
        while(!lastMessage.equals("EOF")){
            lastMessage = repository.read();
            System.out.println("Mensaje leído: " + lastMessage);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Error...");
            }
        }
    }
}
