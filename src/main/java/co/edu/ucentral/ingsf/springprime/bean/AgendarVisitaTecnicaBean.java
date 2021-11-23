package co.edu.ucentral.ingsf.springprime.bean;

import dto.VisitaTecnica;
import lombok.Getter;
import lombok.Setter;
import operaciones.OperacionesVisitasTecnicas;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class AgendarVisitaTecnicaBean implements Serializable {
    private VisitaTecnica visitaTecnica = new VisitaTecnica();

    public String agendarVisitaTecnica(){
//        System.out.println("entrsf");
        OperacionesVisitasTecnicas operacionesVisitasTecnicas = new OperacionesVisitasTecnicas();
            if(operacionesVisitasTecnicas.crear(visitaTecnica)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Su visita se agendo exitosamente"));
                visitaTecnica.setId(0);
                visitaTecnica.setNombreCliente(null);
                visitaTecnica.setCedula(null);
                visitaTecnica.setDireccion(null);
                visitaTecnica.setTelefono(null);
                visitaTecnica.setHoraInicio(null);
                visitaTecnica.setHoraFin(null);
                visitaTecnica.setDescripcion(null);
                return "";
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("No se pudo agendar su visita"));
                return"";
            }

    }
}
