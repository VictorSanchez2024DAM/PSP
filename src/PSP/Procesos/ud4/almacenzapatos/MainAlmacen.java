package PSP.Procesos.ud4.almacenzapatos;

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
}
