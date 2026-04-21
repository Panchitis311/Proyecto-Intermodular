package dam.code.dao;

import dam.code.exceptions.ProductoException;
import dam.code.models.Producto;

import java.util.List;

public interface ProductoDAO {
    void registrar(Producto producto) throws ProductoException;

    void borrar(int id) throws ProductoException;

    List<Producto> findAll() throws ProductoException;

    Producto findById(int id) throws ProductoException;
}
