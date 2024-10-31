package PSP.Procesos.ud3;

public class CountThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Error...");
            }
        }
    }
}
