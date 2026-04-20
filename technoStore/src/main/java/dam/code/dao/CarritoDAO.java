package dam.code.dao;

import dam.code.models.CarritoItem;

import java.util.List;

public interface CarritoDAO {
    void addProducto(int usuarioId, int productoId, int cantidad);

    void cambiarCantidad(int usuarioId, int productoId, int cantidad);

    void borrarProducto(int usuarioId, int productoId);

    void limpiarCarrito (int usuarioId);

    List<CarritoItem> buscarCarritoPorUsuario(int usuarioId);
}
