package PSP.Procesos.ud4.almacenzapatos;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private final static int MAX_PEDIDOS = 10;
    private List<Pedido> pedidos;


    public Almacen(){
        pedidos = new ArrayList<>();
    }


    public synchronized void recibirPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public synchronized Pedido completarPedido(){
        Pedido pedido = pedidos.removeFirst();
        return pedido;
    }

    public synchronized List<Pedido> getPedidos() {
        return pedidos;
    }
}
