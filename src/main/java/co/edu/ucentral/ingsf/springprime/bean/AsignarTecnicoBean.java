package co.edu.ucentral.ingsf.springprime.bean;

import dto.Usuario;
import dto.VisitaTecnica;
import lombok.Getter;
import lombok.Setter;
import operaciones.OperacionesUsuarios;
import operaciones.OperacionesVisitasTecnicas;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class AsignarTecnicoBean implements Serializable {
    private List<Usuario> usuariosTecnicos;


    @PostConstruct
    public void init() {
        OperacionesUsuarios operacionesUsuarios = new OperacionesUsuarios();

        usuariosTecnicos = operacionesUsuarios.consultarTecnicos();
    }

    public void asignarTecnico() { }

}
