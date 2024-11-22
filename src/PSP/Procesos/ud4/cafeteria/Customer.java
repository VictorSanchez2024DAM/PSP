package PSP.Procesos.ud4.cafeteria;

import java.util.List;
import java.util.Random;

public class Customer extends Thread{
    private CoffeeBar coffeeBar;
    private static final List<String> tipos = List.of("cortado", "americano",
            "con leche",
            "capuccino",
            "solo");

    public Customer(CoffeeBar coffeeBar) {
        this.coffeeBar = coffeeBar;
    }

    @Override
    public void run(){
        Random random = new Random();

        coffeeBar.orderCoffee(new CupOfCoffee(random.nextInt(), tipos.get(random.nextInt(0, tipos.size()))));
    }
}
