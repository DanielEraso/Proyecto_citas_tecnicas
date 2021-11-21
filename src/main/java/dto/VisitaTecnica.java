package dto;
import java.io.Serializable;
import java.util.Date;

public class VisitaTecnica implements Serializable {
    private long id;
    private String nombreUsuario;
    private String direccion;
    private long telefono;
    private Date fecha;
    private Date hora;
    private String descripcion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "VisitaTecnica{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
