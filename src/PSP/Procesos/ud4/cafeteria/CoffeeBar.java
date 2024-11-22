package PSP.Procesos.ud4.cafeteria;

import java.util.ArrayList;
import java.util.List;

public class CoffeeBar {
    private List<CupOfCoffee> cups = new ArrayList<>();

    public synchronized void orderCoffee(CupOfCoffee cupOfCoffee){
        while(cups.size() >= 5){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        cups.add(cupOfCoffee);
        this.notifyAll();
    }

    public synchronized CupOfCoffee serveCoffee(){
        while(this.cups.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        CupOfCoffee cup = cups.removeFirst();
        this.notifyAll();
        return cup;
    }
}
