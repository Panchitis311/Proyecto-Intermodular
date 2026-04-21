package dam.code.dao;

import dam.code.models.CarritoItem;

import java.util.List;

public interface CarritoDAO {
    void addProducto(int usuarioId, int productoId, int cantidad);

    void eliminarProducto(int usuarioId, int productoId);

    List<CarritoItem> getCarrito(int usuarioId);
}
