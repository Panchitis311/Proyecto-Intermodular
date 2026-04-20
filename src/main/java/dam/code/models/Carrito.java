package dam.code.models;

import java.util.List;

public class Carrito {
    private int id;
    private Usuario usuario;
    private List<CarritoItem> items;
    private double total;

    public Carrito(Usuario usuario, List<CarritoItem> items, double total) {
        this.usuario = usuario;
        this.items = items;
        this.total = total;
    }

    public Carrito(int id, Usuario usuario, List<CarritoItem> items, double total) {
        this.id = id;
        this.usuario = usuario;
        this.items = items;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<CarritoItem> getItems() {
        return items;
    }

    public void setItems(List<CarritoItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
