package dam.code.dao;

import dam.code.models.Producto;

import java.util.List;

public interface ProductoDAO {
    List<Producto> listarProductos();

    Producto productoPorId(int id);

    void registrar(Producto producto);

    void cargar(Producto producto);

    void borrar(int id);

    List<Producto> buscarPorCategoria(String categoria);

    List<Producto> buscarPorNombre(String nombre);
}
