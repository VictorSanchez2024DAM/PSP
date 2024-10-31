package PSP.Procesos.ud4.ej1;

import PSP.Procesos.ud4.ThreadColor;

public class ej1 {


    public static void main(String[] args) {

        Marcador marcador = new Marcador();

        Thread cyan = new Thread(marcador::agregarPuntos, ThreadColor.ANSI_CYAN.name());
        Thread black = new Thread(marcador::agregarPuntos, ThreadColor.ANSI_BLACK.name());
        Thread yellow = new Thread(marcador::agregarPuntos, ThreadColor.ANSI_YELLOW.name());
        Thread purple = new Thread(marcador::agregarPuntos, ThreadColor.ANSI_PURPLE.name());

            cyan.start();
            black.start();
            yellow.start();
            purple.start();


    }
}
