package PSP.Procesos.ud4;

import java.util.concurrent.TimeUnit;

public class MainThreadColor {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro(TimeUnit.SECONDS);
        Runnable r = () -> {
            cronometro.countDown(5);
        };
        Thread red = new Thread(r, ThreadColor.ANSI_RED.name());
        Thread green = new Thread(cronometro::countDown, ThreadColor.ANSI_GREEN.name());
        HiloAzul azul = new HiloAzul(cronometro, ThreadColor.ANSI_BLUE.name());
        red.start();
        green.start();
        azul.start();
    }
}

class HiloAzul extends Thread{
    private Cronometro cronometro;

    public HiloAzul(Cronometro cronometro, String name) {
        super(name);
        this.cronometro = cronometro;
    }
    @Override
    public void run(){
        cronometro.countDown(5);
    }
}
