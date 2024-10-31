package PSP.Procesos.ud4;

import java.util.concurrent.TimeUnit;

public class Cronometro {

    private TimeUnit timeUnit;

    public Cronometro(TimeUnit timeUnit){
        this.timeUnit = timeUnit;
    }

    public void countDown(){
        countDown(7);
    }
    public void countDown(int count){
        String threadName = Thread.currentThread().getName();
        ThreadColor enumColor = ThreadColor.valueOf(threadName);
        for (int i = count; i > 0 ; i--) {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(enumColor.color() + "Thread i = " + i);
        }
    }

}
