package dam.code.dao.impl;

import dam.code.config.DatabaseConfig;
import dam.code.dao.UsuarioDAO;
import dam.code.exceptions.UsuarioException;
import dam.code.models.Usuario;
import dam.code.models.utils.Rol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void registrar(Usuario usuario, String password) throws UsuarioException {
        // TODO No esta bien escrita la consulta, completarla
        String sql = "INSERT INTO usuarios (dni, nombre, email, password) VALUES (?, ?, ?, ?)";

        try(Connection con = DatabaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, password);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new UsuarioException(e.getMessage());
        }
    }

    @Override
    public Usuario login(String email, String password) throws UsuarioException {
        String sql = "SELECT * FROM usuarios WHERE dni = ? AND password = ?";

        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getInt("numero"),
                        rs.getObject("Rol", Rol.class)
                );
            } else {
                throw new UsuarioException("Credenciales incorrectas");
            }

        } catch (SQLException e) {
            throw new UsuarioException(e.getMessage());
        }
    }
}
