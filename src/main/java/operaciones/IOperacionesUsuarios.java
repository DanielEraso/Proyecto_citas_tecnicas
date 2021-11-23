package operaciones;

import dto.Usuario;

import java.util.List;

public interface IOperacionesUsuarios {
    public Usuario consultarPorUsuario(String nombreUsuario);
    public List<Usuario> consultarTecnicos();
}
