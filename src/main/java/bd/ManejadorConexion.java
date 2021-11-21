package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManejadorConexion {

    private final String BASEDATOS = "VisitaTecnica";
    private final String USUARIO = "postgres";
    private final String CLAVE = "123456";

    public Connection conectarsepostgres (){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/"+BASEDATOS, USUARIO, CLAVE);
//            log.info("Se conecto a postgres");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
//            log.error("Informa error",e);
        }
        return null;
    }

    private final String URL = "visitastecnicas.bd";

    public Connection conectarse (){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:"+URL);

            return conexion;
        } catch (ClassNotFoundException | SQLException e) {

        }
        return null;
    }
    public void desconexion(Connection conexion){
        if (conexion!= null){
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}