package dam.code.dao.impl;

import dam.code.dao.ProductoDAO;
import dam.code.models.Producto;

import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public List<Producto> listarProductos() {
        return List.of();
    }

    @Override
    public Producto productoPorId(int id) {
        return null;
    }

    @Override
    public void registrar(Producto producto) {

    }

    @Override
    public void cargar(Producto producto) {

    }

    @Override
    public void borrar(int id) {

    }

    @Override
    public List<Producto> buscarPorCategoria(String categoria) {
        return List.of();
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return List.of();
    }
}
