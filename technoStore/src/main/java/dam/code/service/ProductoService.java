package dam.code.service;

import dam.code.dao.ProductoDAO;
import dam.code.dao.impl.ProductoDAOImpl;
import dam.code.exceptions.ProductoException;
import dam.code.models.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductoService {

    private final ProductoDAO productoDAO = new ProductoDAOImpl();

    public ObservableList<Producto> obtenerProductos() throws ProductoException {
        return FXCollections.observableArrayList(productoDAO.listar());
    }

    public void agregarProducto(Producto producto) throws ProductoException {
        validarProducto(producto);
        productoDAO.registrar(producto);
    }

    public void eliminarProducto(int id) throws ProductoException {
        productoDAO.eliminar(id);
    }

    private void validarProducto(Producto producto) throws ProductoException {

        if (producto.getPrecio() < 0) {
            throw new ProductoException("El precio no puede ser negativo");
        }

        if (producto.getStock() < 0) {
            throw new ProductoException("El stock no puede ser negativo");
        }
    }

    public ObservableList<Producto> obtenerProductosPorUsuario(int idUsuario) throws ProductoException {
        return FXCollections.observableArrayList(productoDAO.obtenerProductosPorUsuario(idUsuario));
    }
}