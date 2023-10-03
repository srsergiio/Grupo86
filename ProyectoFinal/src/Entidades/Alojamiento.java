package Entidades;

import java.util.Date;

public class Alojamiento {

    public Alojamiento(int idAlojamiento, Date fichaIn, Date fichaOn, Boolean estado, String servicio, double importeDiario, Ciudad CiudadDest) {
        this.idAlojamiento = idAlojamiento;
        this.fichaIn = fichaIn;
        this.fichaOn = fichaOn;
        this.estado = estado;
        this.servicio = servicio;
        this.importeDiario = importeDiario;
        this.CiudadDest = CiudadDest;
    }

    public Alojamiento() {
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

    @Override
    public String toString() {
        return "Alojamiento{" + "idAlojamiento=" + idAlojamiento + ", fichaIn=" + fichaIn + ", fichaOn=" + fichaOn + ", estado=" + estado + ", servicio=" + servicio + ", importeDiario=" + importeDiario + ", CiudadDest=" + CiudadDest + '}';
    }

    private int idAlojamiento;

    private Date fichaIn;

    private Date fichaOn;

    private Boolean estado;

    private String servicio;

    private double importeDiario;

    private Ciudad CiudadDest;
}
