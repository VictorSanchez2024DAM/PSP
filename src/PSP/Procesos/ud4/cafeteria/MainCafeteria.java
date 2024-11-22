package PSP.Procesos.ud4.cafeteria;

/*
    Simulamos una cafeteria con una barra donde los productores seran los clientes realizando
    pedidos de café y los consumidores serán los baristas sirviendo el café

    --> CupOfCoffee: representa una taza de café, con un id, y un tipo de café.
    Tendrá el método drink que imprime un mensaje
    "El cliente está disfrutando del café id y tipo"
    --> CoffeeBar: Tendrá una lista de tazas de café.
    -orderCoffee
    -serveCoffee

    --> CoffeeCustomer: Son los clientes que piden cafés de manera aleatoria.
    --> CoffeeBarista: Son los baristas sirviendo café. Llamará
    al método drink.
    La barra de cafe solo caben 5 clientes y los pedidos se realizan
    conforme se van pidiendo.

    Main con 3 clientes y 3 baristas.
    Tipos de cafes: cortado, americano, con leche, capuccino, solo.

    2) - ¿Cómo podrías implementar una política de prioridad para los pedidos de café?
    Por ejemplo, algunos clientes podrían tener prioridad sobre otros.
 */
public class MainCafeteria {
    public static void main(String[] args) {
        final CoffeeBar coffeeBar = new CoffeeBar();
        for (int i = 0 ; i < 3 ; i++){
            new Barista(coffeeBar).start();
            new Customer(coffeeBar).start();
        }
    }
}
