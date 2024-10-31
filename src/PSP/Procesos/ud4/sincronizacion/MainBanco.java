package PSP.Procesos.ud4.sincronizacion;

/**
 *  Objetos --> Bloqueo intrínseco, lock, monitor
 *  los hilos compiten por tener ese bloqueo
 */
public class MainBanco {
    public static void main(String[] args) {
        final BankAccount banco = new BankAccount(10000, "Victor");

        Thread h1 = new Thread(() -> banco.withdraw(2500));
        Thread h2 = new Thread(() -> banco.deposit(5000));
        Thread h5 = new Thread(() -> banco.setName("Severo"));
        Thread h3 = new Thread(() -> banco.withdraw(2500));
        Thread h4 = new Thread(() -> banco.withdraw(5000));

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
        System.out.println(banco.getBalance());
    }
}
