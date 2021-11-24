package co.edu.ucentral.ingsf.springprime.bean;

import dto.Usuario;
import dto.VisitaTecnica;
import lombok.Getter;
import lombok.Setter;
import operaciones.OperacionesUsuarios;
import operaciones.OperacionesVisitasTecnicas;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
@SessionScoped
public class AsignarTecnicoBean implements Serializable {
    private List<Usuario> usuariosTecnicos;

    @ManagedProperty(value ="#{listaVisitasBean}")
    private ListaVisitasBean listaVisitasBean;
    @PostConstruct
    public void init() {
        OperacionesUsuarios operacionesUsuarios = new OperacionesUsuarios();

        usuariosTecnicos = operacionesUsuarios.consultarTecnicos();
    }

    public void asignarTecnico() {
        System.out.println(listaVisitasBean.getVisitaTecnicaSeleccionada());
    }

}
