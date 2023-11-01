package Entidades;
import Entidades.Ciudad;
import java.time.LocalDate;
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
    private LocalDate fechaI;
    private LocalDate fechaV;
    private Ciudad COrigen;
    private Ciudad CDestino;
    
    
    
    public Pasaje(){}

    public Pasaje(int idPasaje, String tipoTransporte, Date fechaIda, Date fechaVuelta, int estado, double importe, int ciudadOrigen, int ciudadDestino, LocalDate fechaI, LocalDate fechaV, Ciudad COrigen, Ciudad CDestino) {
        this.idPasaje = idPasaje;
        this.tipoTransporte = tipoTransporte;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.estado = estado;
        this.importe = importe;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaI = fechaI;
        this.fechaV = fechaV;
        this.COrigen = COrigen;
        this.CDestino = CDestino;
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

    public LocalDate getFechaI() {
        return fechaI;
    }

    public void setFechaI(LocalDate fechaI) {
        this.fechaI = fechaI;
    }

    public LocalDate getFechaV() {
        return fechaV;
    }

    public void setFechaV(LocalDate fechaV) {
        this.fechaV = fechaV;
    }

    public Ciudad getCOrigen() {
        return COrigen;
    }

    public void setCOrigen(Ciudad COrigen) {
        this.COrigen = COrigen;
    }

    public Ciudad getCDestino() {
        return CDestino;
    }

    public void setCDestino(Ciudad CDestino) {
        this.CDestino = CDestino;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "idPasaje=" + idPasaje + ", tipoTransporte=" + tipoTransporte + ", fechaIda=" + fechaIda + ", fechaVuelta=" + fechaVuelta + ", estado=" + estado + ", importe=" + importe + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", fechaI=" + fechaI + ", fechaV=" + fechaV + ", COrigen=" + COrigen + ", CDestino=" + CDestino + '}';
    }
    
   
}
