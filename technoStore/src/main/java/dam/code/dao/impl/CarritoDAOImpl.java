package dam.code.dao.impl;

import dam.code.config.DatabaseConfig;
import dam.code.dao.CarritoDAO;
import dam.code.models.CarritoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarritoDAOImpl implements CarritoDAO {

    @Override
    public void addProducto(int usuarioId, int productoId, int cantidad) {
        String sql = "INSERT INTO carrito_item (usuario_id, producto_id, cantidad, precio_unitario) VALUES (?, ?, ?, (SELECT precio FROM producto WHERE id = ?))";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuarioId);
            ps.setInt(2, productoId);
            ps.setInt(3, cantidad);
            ps.setInt(4, productoId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(int usuarioId, int productoId) {
        String sql = "DELETE FROM carrito_item WHERE usuario_id = ? AND producto_id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuarioId);
            ps.setInt(2, productoId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CarritoItem> getCarrito(int usuarioId) {
        List<CarritoItem> lista = new ArrayList<>();

        String sql = "SELECT c.id, c.cantidad, c.precio_unitario, p.* " +
                "FROM carrito_item c " +
                "JOIN producto p ON c.producto_id = p.id " +
                "WHERE c.usuario_id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

//                Producto p = new Producto();
//                p.setId(rs.getInt("id"));
//                p.setNombre(rs.getString("nombre"));
//                p.setPrecio(rs.getDouble("precio"));
//
//                CarritoItem item = new CarritoItem();
//                item.setId(rs.getInt("id"));
//                item.setProducto(p);
//                item.setCantidad(rs.getInt("cantidad"));
//                item.setPrecioUnitario(rs.getDouble("precio_unitario"));

                lista.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
