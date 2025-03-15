package restaurante;
import java.util.*;

public class Pedido {
    public int numeroPedido;
    public String cliente;
    public List<String> listaDePratos;
    public float total;

    public Pedido(int numeroPedido, String cliente, List<String> listaDePratos, float total) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.listaDePratos = listaDePratos;
        this.total = total;
    }

    public int getNumeroPedido() { return numeroPedido; }

    public String getCliente() { return cliente; }

    public List<String> getListaDePratos() { return listaDePratos; }

    public float getTotal() { return total; }

}
