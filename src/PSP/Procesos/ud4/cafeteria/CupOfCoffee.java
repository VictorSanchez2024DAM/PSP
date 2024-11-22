package PSP.Procesos.ud4.cafeteria;

public class CupOfCoffee {
    private int id;
    private String tipoCafe;

    public CupOfCoffee(int id, String tipoCafe) {
        this.id = id;
        this.tipoCafe = tipoCafe;
    }

    public int getId() {
        return this.id;
    }

    public String getTipoCafe() {
        return this.tipoCafe;
    }

    public void drink(){
        System.out.println("El cliente esta disfrutando del cafe " + this.tipoCafe + " con id " + this.id);
    }
}
