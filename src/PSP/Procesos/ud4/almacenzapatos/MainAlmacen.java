package PSP.Procesos.ud4.almacenzapatos;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Consumer/Producer para un centro de almacén de zapatos.
 *
 * El código del productor generará pedidos y los enviará el almacén
 * para que este los procese.
 * El consumidor procesará esos pedidos en orden FIFO.
 *
 * Debemos crear las siguientes clases:
 * - Pedido, incluye identificadores de pedido, tipo de zapato y la cantidad del pedido
 * - Almacen, tendrá una lista de pedidos, como máximo mi almacén solo puede
 * almacenar 10 pedidos
 * --> recibirPedido: recibe un pedido y lo añade a la lista.
 * --> completarPedido: procesa el pedido, es decir, lo quita de la lista.
 * (FIFO).
 *
 * - Main:
 * --> array de tipos de zapatos, static final: botas, taconas, deportivos, sandalias
 * mocasines, sneakers, crocs.
 * --> un hilo productos, que generará 10 pedidos, id aleatorio, tipo zapatos aleatorio,
 * cantidad aleatorio: 20-25
 * --> dos hilos consumidores, cada hilo consumidor, completará 5 pedidos.
 */
public class MainAlmacen {
    private static final String[] tipoZapatos = {"botas", "tacones", "deportivos", "sandalias",
            "mocasines", "crocs"};
    public static void main(String[] args) {
        final Almacen almacen = new Almacen();
        Random random = new Random();

        Runnable r = () -> {

            for (int i = 0; i < 10; i++) {
                synchronized (almacen) {
                    while (almacen.getPedidos().size() >= 10) {
                        try {
                            almacen.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                almacen.recibirPedido(new Pedido(i, tipoZapatos[random.nextInt(0, 5 + 1)],
                        random.nextInt(20, 25 + 1)));

                    almacen.notifyAll();
            }

        }
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(r);
        executor.shutdown();

        for (int i = 0; i < 2; i++) {
            new Thread(() ->{

                for (int j = 0; j < 5; j++) {
                    synchronized (almacen) {
                        while (almacen.getPedidos().isEmpty()) {
                            try {
                                almacen.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    System.out.println(almacen.completarPedido());
                    almacen.notifyAll();
                }
                }

            }).start();
        }
    }
}
