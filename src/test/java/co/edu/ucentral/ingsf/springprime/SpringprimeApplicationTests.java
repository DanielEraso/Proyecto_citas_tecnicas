package co.edu.ucentral.ingsf.springprime;

import bd.ManejadorConexion;
import dto.Usuario;
import dto.VisitaTecnica;
import operaciones.OperacionesUsuarios;
import operaciones.OperacionesVisitasTecnicas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

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


    @DisplayName("prueba crear usuario ")
    @Test
    public void testPruebaCrearUsuario(){
        OperacionesUsuarios oper = new OperacionesUsuarios();
        Usuario u = new Usuario();
        u.setId(7);
        u.setNombre("Carlos");
        u.setApellido("Estrada");
        u.setTelefono(3133545);
        u.setCorreo("cestrada@ucentral.edu.co");
        u.setNombreUsuario("cestrada");
        u.setEsAdmin(true);
        u.setContraseña("Carlos1");
        boolean rta= oper.crear(u);
        System.out.println(u);
        assertTrue(rta);
    }

    @DisplayName("prueba crear visita tecnica ")
    @Test
    public void testPruebaCrearVisitaTecnica(){
        OperacionesVisitasTecnicas oper = new OperacionesVisitasTecnicas();
        VisitaTecnica u = new VisitaTecnica();
//        u.setId();
        u.setNombreCliente("Daniel Felipe Eraso Acero");
        u.setCedula("1016061656");
        u.setDireccion("Kra87B #19A - 66");
        u.setTelefono("3133667782");
        u.setHoraInicio(new Date());
        u.setHoraFin(new Date());
        u.setDescripcion("No sirve el internet");
        boolean rta= oper.crear(u);
        System.out.println(u);
        assertTrue(rta);
    }

    @DisplayName("prueba Consulta All Visitas tecnicas ")
    @Test
    public void consultaAllVisitasTecnicas(){
        OperacionesVisitasTecnicas oper = new OperacionesVisitasTecnicas();
        List<VisitaTecnica> v = oper.consultar();
        for (VisitaTecnica dato:v) {
            System.out.println(dato);

        }

        assertTrue(v.size()>0);

    }

}
