package Entidades;
import Entidades.Ciudad;
import java.util.Date;
public class Pasaje {


    private int idPasaje;
    private String tipoTransporte;
    private Date fechaIda;
    private Date fechaVuelta;
    private int estado;
    private double importe;
    private int ciudadOrigen;
    private int ciudadDestino;
    
    
    public Pasaje(){}
    public Pasaje(int idPasaje, String tipoTransporte, Date fechaIda, Date fechaVuelta, int estado, double importe, int ciudadOrigen, int ciudadDestino) {
        this.idPasaje = idPasaje;
        this.tipoTransporte = tipoTransporte;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.estado = estado;
        this.importe = importe;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }
    public int getIdPasaje() {
        return idPasaje;
    }
    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }
    public String getTipoTransporte() {
        return tipoTransporte;
    }
    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
    public Date getFechaIda() {
        return fechaIda;
    }
    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }
    public Date getFechaVuelta() {
        return fechaVuelta;
    }
    public void setFechaVuelta(Date fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public int getCiudadOrigen() {
        return ciudadOrigen;
    }
    public void setCiudadOrigen(int ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }
    public int getCiudadDestino() {
        return ciudadDestino;
    }
    public void setCiudadDestino(int ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "idPasaje=" + idPasaje + ", tipoTransporte=" + tipoTransporte + ", fechaIda=" + fechaIda + ", fechaVuelta=" + fechaVuelta + ", estado=" + estado + ", importe=" + importe + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + '}';
    }
    
    
 
}
