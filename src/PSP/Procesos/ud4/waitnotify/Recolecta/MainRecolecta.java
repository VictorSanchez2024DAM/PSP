package PSP.Procesos.ud4.waitnotify.Recolecta;

/**
 * Se tienen varios hilos que realizan una colecta, pero no se puede recoger
 * más dinero una vez se ha llegado a una catidad límite, 2000
 *
 * Habrá hilos consumidores que reciben una cantidad de dinero, entre 10-40,
 * a intervalos de tiempo aleatorios entre 20-300 ms
 *
 * Habrá hilos recolectores, no pueden recoger dinero cuando se ha llegado al límite.
 * Deberán esperar a que los hilos consumidores retiren dinero.
 * Si los hilos consumodres no pueden retiran dinero, deben esperar a que los hilos recolectores
 * aporten dinero.
 *
 * Los hilos se ejecutan indefinidamente
 * Main crearemos 3 hilos recolectores y 1 hilo consumidor y vamos a ver que pasa.
 */
public class MainRecolecta {
    public static void main(String[] args) {
        final Recolecta recolecta = new Recolecta();

        for (int i = 0; i < 3; i++) {
            new Thread(new Recolector(recolecta)).start();
        }

        for (int i = 0; i < 1; i++) {
            new Thread(new Consumidor(recolecta)).start();
        }

    }
}
