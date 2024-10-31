package PSP.Procesos.ud4.ej1;

import PSP.Procesos.ud4.ThreadColor;

public class ej2 {
    public static void main(String[] args) {
        Calculadora calculadora1 = new Calculadora();
        Calculadora calculadora2 = new Calculadora();
        Calculadora calculadora3 = new Calculadora();

        Thread cyanSum = new Thread(calculadora1::calcularSuma, ThreadColor.ANSI_CYAN.name());
        Thread redSum = new Thread(calculadora1::calcularSuma, ThreadColor.ANSI_RED.name());
        Thread yellowSum = new Thread(calculadora1::calcularSuma, ThreadColor.ANSI_YELLOW.name());

        cyanSum.start();
        redSum.start();
        yellowSum.start();
    }
}
