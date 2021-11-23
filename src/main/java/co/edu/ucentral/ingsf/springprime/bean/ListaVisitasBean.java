package co.edu.ucentral.ingsf.springprime.bean;

import dto.Usuario;
import dto.VisitaTecnica;
import lombok.Getter;
import lombok.Setter;
import operaciones.OperacionesVisitasTecnicas;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class ListaVisitasBean implements Serializable {
    private List<VisitaTecnica> visitasTecnicas;

    private VisitaTecnica visitaTecnicaSeleccionada;

    @PostConstruct
    public void init() throws IOException {
        OperacionesVisitasTecnicas operacionesVisitasTecnicas = new OperacionesVisitasTecnicas();

        visitasTecnicas = operacionesVisitasTecnicas.consultar();

    }

    public void mostrarTecnicos() {
        System.out.println(visitaTecnicaSeleccionada);
        Map<String,Object> options = new HashMap<>();
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("asignarTecnico", options, null);
    }

}
