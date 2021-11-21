package operaciones;

import bd.ManejadorConexion;
import dto.Usuario;
import dto.VisitaTecnica;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OperacionesVisitasTecnicas implements Operacion<VisitaTecnica>{
    private static Logger log = LogManager.getLogger(OperacionesUsuarios.class.getName());

    private final String sqlCrear= "INSERT INTO \"VisitaTecnica\"( nombre_Cliente, cedula, direccion, telefono, hora_inicio, hora_fin, descripcion_problema) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
    private final String sqlConsultaPorNombreUsuario= "select * from \"Usuario\" WHERE \"nombreUsuario\" =?";
    //    private final String sqlModificar= "UPDATE vehiculo SET precio = ?, marca =? WHERE placa = ?";
//    private final String sqlConsultaPK= "select * from vehiculo  WHERE placa = ?";
//    private final String sqlConsultaALL= "select * from vehiculo  ";
//    private final String sqlBorrar= "delete from vehiculo  WHERE placa = ?";
    @Override
    public boolean crear(VisitaTecnica dato) {
        if (dato == null){
            return false;
        }

        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsepostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlCrear);

//                ps.setLong(1, dato.getId());
                ps.setString(1, dato.getNombreCliente());
                ps.setString(2, dato.getCedula());
                ps.setString(3, dato.getDireccion());
                ps.setString(4, dato.getTelefono());
                ps.setDate(5, new java.sql.Date(dato.getHoraInicio().getTime()));
                ps.setDate(6, new java.sql.Date(dato.getHoraFin().getTime()));
                ps.setString(7, dato.getDescripcion());


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
    public boolean modificar(VisitaTecnica dato) {
        return false;
    }

    @Override
    public boolean borrar(VisitaTecnica dato) {
        return false;
    }

    @Override
    public VisitaTecnica consulta(String pk) {
        return null;
    }

    @Override
    public List<VisitaTecnica> consultar() {
        return null;
    }

}
