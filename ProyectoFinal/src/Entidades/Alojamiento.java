package Entidades;

import java.time.LocalDate;
import java.util.Date;

public class Alojamiento {

    public Alojamiento(int idAlojamiento, Date fichaIn, Date fichaOn, Boolean estado, String servicio, double importeDiario, Ciudad CiudadDest, String tipo, LocalDate fechaI, LocalDate fechaF, Ciudad ciudad) {
        this.idAlojamiento = idAlojamiento;
        this.fichaIn = fichaIn;
        this.fichaOn = fichaOn;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.CiudadDest = CiudadDest;
        this.tipo = tipo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.ciudad = ciudad;
        
    }



 
    public Alojamiento() {
    }

    public Alojamiento(int idAlojamiento, java.sql.Date fechaI, java.sql.Date fechaF, String tipo, String servicio, int importeD, int ciudad, boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Alojamiento(int idAlojamiento, Date fichaIn, Date fichaOn, Boolean estado, String servicio, double importeDiario, Ciudad CiudadDest, String tipo) {
        this.idAlojamiento = idAlojamiento;
        this.fichaIn = fichaIn;
        this.fichaOn = fichaOn;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.CiudadDest = CiudadDest;
        this.tipo = tipo;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Date getFichaIn() {
        return fichaIn;
    }

    public void setFichaIn(Date fichaIn) {
        this.fichaIn = fichaIn;
    }

    public Date getFichaOn() {
        return fichaOn;
    }

    public void setFichaOn(Date fichaOn) {
        this.fichaOn = fichaOn;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getImporteDiario() {
        return importeDiario;
    }

    public void setImporteDiario(double importeDiario) {
        this.importeDiario = importeDiario;
    }

    public Ciudad getCiudadDest() {
        return CiudadDest;
    }

    public void setCiudadDest(Ciudad CiudadDest) {
        this.CiudadDest = CiudadDest;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaI() {
        return fechaI;
    }

    public void setFechaI(LocalDate fechaI) {
        this.fechaI = fechaI;
    }

    public LocalDate getFechaF() {
        return fechaF;
    }

    public void setFechaF(LocalDate fechaF) {
        this.fechaF = fechaF;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

   

    @Override
    public String toString() {
        return "Alojamiento{" + "idAlojamiento=" + idAlojamiento + ", fichaIn=" + fichaIn + ", fichaOn=" + fichaOn + ", estado=" + estado + ", servicio=" + servicio + ", importeDiario=" + importeDiario + ", CiudadDest=" + CiudadDest + ", tipo=" + tipo + ", fechaI=" + fechaI + ", fechaF=" + fechaF + ", ciudad=" + ciudad +  '}';
    }
    

    private int idAlojamiento;

    private Date fichaIn;

    private Date fichaOn;

    private Boolean estado;

    private String servicio;

    private double importeDiario;

    private Ciudad CiudadDest;
    
    private String tipo;
    
    private LocalDate fechaI;
    private LocalDate fechaF;
    private Ciudad ciudad;

   
    
}
