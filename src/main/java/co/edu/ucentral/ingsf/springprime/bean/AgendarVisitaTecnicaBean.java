package co.edu.ucentral.ingsf.springprime.bean;

import dto.VisitaTecnica;
import lombok.Getter;
import lombok.Setter;
import operaciones.OperacionesVisitasTecnicas;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class AgendarVisitaTecnicaBean {
    private VisitaTecnica visitaTecnica = new VisitaTecnica();

    public String agendarVisitaTecnica(){
        System.out.println("entrsf");
        OperacionesVisitasTecnicas operacionesVisitasTecnicas = new OperacionesVisitasTecnicas();
        operacionesVisitasTecnicas.crear(visitaTecnica);
        return "";
    }
}
