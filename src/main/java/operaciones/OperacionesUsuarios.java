package operaciones;

import bd.ManejadorConexion;
import dto.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesUsuarios implements Operacion<Usuario>, IOperacionesUsuarios{
    private static Logger log = LogManager.getLogger(OperacionesUsuarios.class.getName());

    private final String sqlCrear= "INSERT INTO Usuario(id, nombre, apellido, telefono, correo, nombreUsuario, esAdmin, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String sqlConsultaPorNombreUsuario= "select * from \"Usuario\" WHERE \"nombreUsuario\" =?";
//    private final String sqlModificar= "UPDATE vehiculo SET precio = ?, marca =? WHERE placa = ?";
//    private final String sqlConsultaPK= "select * from vehiculo  WHERE placa = ?";
//    private final String sqlConsultaALL= "select * from vehiculo  ";
//    private final String sqlBorrar= "delete from vehiculo  WHERE placa = ?";
    @Override
    public boolean crear(Usuario dato) {
        if (dato == null){
            return false;
        }else if (dato.getId() == 0){
            return false;

        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarse();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlCrear);

                ps.setLong(1, dato.getId());
                ps.setString(2, dato.getNombre());
                ps.setString(3, dato.getApellido());
                ps.setInt(4, dato.getTelefono());
                ps.setString(5, dato.getCorreo());
                ps.setString(6, dato.getNombreUsuario());
                ps.setBoolean(7, dato.isEsAdmin());
                ps.setString(8, dato.getContraseña());


                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
                log.error("Mensaje ", throwables);
            } finally {
                mc.desconexion(conexActiva);

            }
        }

        return false;
    }
    @Override
    public boolean modificar(Usuario dato) {
        return false;
    }

    @Override
    public boolean borrar(Usuario dato) {
        return false;
    }

    @Override
    public Usuario consulta(String pk) {
        return null;
    }

    @Override
    public List<Usuario> consultar() {
        return null;
    }

    @Override
    public Usuario consultarPorUsuario(String nombreUsuario) {
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsepostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaPorNombreUsuario);

                ps.setString(1, nombreUsuario);

                ResultSet resultado = ps.executeQuery();

                if (resultado.next()){
                    Usuario usuario = new Usuario();
                    usuario.setNombreUsuario(resultado.getString("nombreUsuario"));
                    usuario.setContraseña(resultado.getString("contraseña"));
                    usuario.setEsAdmin(resultado.getBoolean("esAdmin"));
                    return usuario;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return null;
    }

}