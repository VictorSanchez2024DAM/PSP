package PSP.Procesos.ud4.mainExecutor;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainExecutor {
    public static int cuentaAtras(){
        for (int i = 10; i < 0; i--) {
            System.out.println(i);
        }
        return 1;
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        // executorService.scheduleAtFixedRate();
        // executorService.scheduleWithFixedDelay();

        try{
            Callable<Integer> c = () -> {
                int total = 0;
                for(int i = 0 ; i < 100 ; i++){
                    total+=i;
                }
                return total;
            };

            List<Callable<Integer>> tasks = new ArrayList<>();
            tasks.add(c);
            tasks.add(c);
            tasks.add(c);

           Future<Integer> resultado = executor.submit(c);

            resultado.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
        System.out.println("hola");

    }
}
