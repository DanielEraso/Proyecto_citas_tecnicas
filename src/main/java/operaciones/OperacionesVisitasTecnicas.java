package operaciones;

import bd.ManejadorConexion;
import dto.Usuario;
import dto.VisitaTecnica;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OperacionesVisitasTecnicas implements Operacion<VisitaTecnica>, IOperacionesVisitasTecnicas{
    private static Logger log = LogManager.getLogger(OperacionesUsuarios.class.getName());

    private final String sqlCrear= "INSERT INTO \"VisitaTecnica\"( nombre_Cliente, cedula, direccion, telefono, hora_inicio, hora_fin, descripcion_problema) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
    private final String sqlConsultaPorNombreUsuario= "select * from \"Usuario\" WHERE \"nombreUsuario\" =?";
    //    private final String sqlModificar= "UPDATE vehiculo SET precio = ?, marca =? WHERE placa = ?";
    private final String sqlModificarTecnicoId = "UPDATE \"VisitaTecnica\" SET tecnico_id=? WHERE id = ?";
    //    private final String sqlConsultaPK= "select * from vehiculo  WHERE placa = ?";
    private final String sqlConsultaALL= "select * from \"VisitaTecnica\"";
//    private final String sqlBorrar= "delete from vehiculo  WHERE placa = ?";

    private SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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
                ps.setString(5, formateador.format(dato.getHoraInicio()));
                ps.setString(6, formateador.format(dato.getHoraFin()));
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
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsepostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaALL);

                ResultSet resultado = ps.executeQuery();
                List<VisitaTecnica> datos = new ArrayList<>();
                while (resultado.next()){
                    VisitaTecnica visitaTecnica = new VisitaTecnica();
                    visitaTecnica.setId(resultado.getLong("id"));
                    visitaTecnica.setNombreCliente(resultado.getString("nombre_cliente"));
                    visitaTecnica.setCedula(resultado.getString("cedula"));
                    visitaTecnica.setDireccion(resultado.getString("direccion"));
                    visitaTecnica.setTelefono(resultado.getString("telefono"));
                    visitaTecnica.setHoraInicio(formateador.parse(resultado.getString("hora_inicio")));
                    visitaTecnica.setHoraFin(formateador.parse(resultado.getString("hora_fin")));
                    visitaTecnica.setDescripcion(resultado.getString("descripcion_problema"));
                    visitaTecnica.setTecnicoId(resultado.getLong("tecnico_id"));
                    datos.add(visitaTecnica);
                }
                return datos;

            } catch (SQLException | ParseException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return new ArrayList<>();
    }

    @Override
    public boolean modificarTecnicoId(Long visitaTecnicaId, Long TecnicoId) {
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsepostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlModificarTecnicoId);

                ps.setLong(1, TecnicoId);
                ps.setLong(2, visitaTecnicaId);
                int resultado = ps.executeUpdate();
                if(resultado > 0) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);
            }
        }
        return false;
    }
}
