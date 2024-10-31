package PSP.Procesos.ud4.sincronizacion;

/**
 * Interferencia entre hilos --> heap (objetos y sus datos)
 * Sincronización --> controlar el acceso a los objetos compartidos
 * - Métodos
 * - Bloques de código
 */
public class BankAccount {
    private double balance ;
    private String name;

    private final static Object lockName = new Object();
    private final static Object lockBalance = new Object();

    public BankAccount(double balance, String name){
        this.name = name;
        this.balance = balance;
    }
    public void setName(String name){
        synchronized (lockName){
            System.out.println("cambio de nombre" + name);
            this.name = name;
        }

    }
    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        try {
            System.out.println("Hablando con el cajero");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
        synchronized (lockBalance){
            double actual = this.balance;
            this.balance += amount;
            System.out.printf("Balance actual: %.0f, ingreso de: %.0f." + "Nuevo balance: %.0f %n", actual, amount, this.balance);
        }


    }

    public void withdraw(double amount){
        try {
            System.out.println("Hablando con el cajero");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
        synchronized (lockBalance){
            double actual = this.balance;
            if(this.balance >= amount){
                this.balance-= amount;
                System.out.printf("Balance actual: %.0f, retirada de: %.0f." + "Nuevo balance: %.0f %n", actual, amount, this.balance);
            } else{
                System.out.println("Fondos insuficientes");
            }
        }


    }
}
