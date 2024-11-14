package PSP.Procesos.ud4.almacenzapatos;

public class Pedido {
    private int id;
    private String tipoZapato;
    private int cantidad;

    public Pedido(int id, String tipoZapato, int cantidad) {
        this.id = id;
        this.tipoZapato = tipoZapato;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getTipoZapato() {
        return tipoZapato;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", tipoZapato='" + tipoZapato + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
