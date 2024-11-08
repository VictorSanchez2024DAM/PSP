package PSP.Procesos.ud4.waitnotify;

public class MainChat {
    public static void main(String[] args) {
        final MessageRepository repository = new MessageRepository();
        new Thread(new Escritor(repository)).start();
        new Thread(new Lector(repository)).start();
    }
}
