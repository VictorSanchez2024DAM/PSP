package PSP.Procesos.ud4.cafeteria;

public class Barista extends Thread{
    private CoffeeBar coffeeBar;

    public Barista(CoffeeBar coffeeBar) {
        this.coffeeBar = coffeeBar;
    }

    @Override
    public void run(){
        coffeeBar.serveCoffee().drink();
    }
}
