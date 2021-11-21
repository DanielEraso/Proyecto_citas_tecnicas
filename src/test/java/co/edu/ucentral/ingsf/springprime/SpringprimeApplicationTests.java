package co.edu.ucentral.ingsf.springprime;

import bd.ManejadorConexion;
import dto.Usuario;
import operaciones.OperacionesUsuarios;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

@SpringBootTest
class SpringprimeApplicationTests {



    @Test
    void contextLoads() {

    }
    @DisplayName("Pruebas de conexion ")
    @Test
    public void testPruebasConexionPostgres(){
        ManejadorConexion c = new ManejadorConexion();
        Connection con = c.conectarsepostgres();
        assertNotNull(con );
    }

    @DisplayName("Pruebas de conexion ")
    @Test
    public void testPruebasConexion(){
        ManejadorConexion c = new ManejadorConexion();
        Connection con = c.conectarse();
//        System.out.println("CONEXION: "+con);
        assertNotNull(con);
    }

//    @DisplayName("prueba crear usuario ")
//    @Test
//    public void testPruebaCrearUsuario(){
//        OperacionesUsuarios oper = new OperacionesUsuarios();
//        Usuario u = new Usuario();
//        u.setId(1);
//        u.setNombre("Daniel");
//        u.setApellido("Felipe");
//        u.setTelefono(313366);
//        u.setCorreo("derasoa@ucentral.edu.co");
//        u.setNombreUsuario("derasoa");
//        u.setEsAdmin(true);
//        u.setContraseña("123456");
//        boolean rta= oper.crear(u);
////        System.out.println(u);
//        assertTrue(rta);
//    }
}
