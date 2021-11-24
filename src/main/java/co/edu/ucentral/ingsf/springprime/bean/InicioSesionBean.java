package co.edu.ucentral.ingsf.springprime.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.ucentral.ingsf.springprime.servicios.DataService;
import dto.Usuario;
import lombok.Getter;
import lombok.Setter;
import operaciones.OperacionesUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class InicioSesionBean implements Serializable {

    private String nombreUsuario;
    private String contraseña;
    public String ingresarAdmin (){
        OperacionesUsuarios operacionesUsuarios = new OperacionesUsuarios();
        Usuario usuario = operacionesUsuarios.consultarPorUsuario(nombreUsuario);
        if (nombreUsuario == null || nombreUsuario.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese usuario", ""));
            return "";
        }

        if (contraseña == null || contraseña.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese contraseña", ""));
            return "";
        }
        if (usuario == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", ""));
            return "";
        }

        if (!usuario.getContraseña().equals(contraseña)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña no es valida", ""));
            return "";
        }

        if (!usuario.isEsAdmin()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no es administrador", ""));
            return "";
        }

        return "usuarioAdmin";
    }
    public String ingresarTecnico (){
        OperacionesUsuarios operacionesUsuarios = new OperacionesUsuarios();
        Usuario usuario = operacionesUsuarios.consultarPorUsuario(nombreUsuario);
        if (nombreUsuario == null || nombreUsuario.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese usuario", ""));
            return "";
        }

        if (contraseña == null || contraseña.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese contraseña", ""));
            return "";
        }
        if (usuario == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", ""));
            return "";
        }

        if (!usuario.getContraseña().equals(contraseña)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña no es valida", ""));
            return "";
        }

        if (usuario.isEsAdmin()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no es tecnico", ""));
            return "";
        }

        return "usuarioTecnico";

    }

}
