package dam.code.dao;

import dam.code.models.Usuario;

public interface UsuarioDAO {
    Usuario buscarPorId(int id);

    Usuario buscarPorEmail(String email);

    void registrar(Usuario usuario, String password);

    void cargar(Usuario usuario);

    void borrar(int id);
}
