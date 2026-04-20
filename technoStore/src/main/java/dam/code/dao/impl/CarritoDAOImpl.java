package dam.code.dao.impl;

import dam.code.dao.CarritoDAO;
import dam.code.models.CarritoItem;

import java.util.List;

public class CarritoDAOImpl implements CarritoDAO {
    @Override
    public void addProducto(int usuarioId, int productoId, int cantidad) {

    }

    @Override
    public void cambiarCantidad(int usuarioId, int productoId, int cantidad) {

    }

    @Override
    public void borrarProducto(int usuarioId, int productoId) {

    }

    @Override
    public void limpiarCarrito(int usuarioId) {

    }

    @Override
    public List<CarritoItem> buscarCarritoPorUsuario(int usuarioId) {
        return List.of();
    }
}
