package dam.code.dao.impl;

import dam.code.config.DatabaseConfig;
import dam.code.dao.ProductoDAO;
import dam.code.exceptions.ProductoException;
import dam.code.models.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void registrar(Producto producto) throws ProductoException {
        String sql = "INSERT INTO producto (nombre, descripcion, precio, stock, categoria, marca, modelo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

//            ps.setString(1, producto.getNombre());
//            ps.setString(2, producto.getDescripcion());
//            ps.setDouble(3, producto.getPrecio());
//            ps.setInt(4, producto.getStock());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(int id) throws ProductoException {

    }

    @Override
    public List<Producto> findAll() throws ProductoException {
        return List.of();
    }

    @Override
    public Producto findById(int id) throws ProductoException {
        return null;
    }
}
