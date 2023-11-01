package Entidades;

import java.time.LocalDate;
import java.util.Date;

public class Alojamiento {
    private int idAlojamiento;
    private Date fechaI;
    private Date fechaF;
    private String tipo;
    private String servicio;
    private double importeD;
    private int ciudad;
    private int estado;
    private Date inicioTemporada;
    private Date finTemporada;
    private Ciudad ciudades;
    private LocalDate fechai;
    private LocalDate fechaf;
    
    public Alojamiento() {
    }

    public Alojamiento(Ciudad ciudades) {
        this.ciudades = ciudades;
    }

    public Alojamiento(int idAlojamiento, Date fechaI, Date fechaF, String tipo, String servicio, double importeD, int ciudad, int estado, Date inicioTemporada, Date finTemporada, LocalDate fechai, LocalDate fechaf) {
        this.idAlojamiento = idAlojamiento;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.tipo = tipo;
        this.servicio = servicio;
        this.importeD = importeD;
        this.ciudad = ciudad;
        this.estado = estado;
        this.inicioTemporada = inicioTemporada;
        this.finTemporada = finTemporada;
        this.fechai = fechai;
        this.fechaf = fechaf;
    }

    public Alojamiento(int idAlojamientoEnBD, java.sql.Date fechaI, java.sql.Date fechaF, String tipo, String servicio, double importeD, int ciudad, int estado, Date inicioTemporada, Date finTemporada) {
        this.idAlojamiento = idAlojamiento;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.tipo = tipo;
        this.servicio = servicio;
        this.importeD = importeD;
        this.ciudad = ciudad;
        this.estado = estado;
        this.inicioTemporada = inicioTemporada;
        this.finTemporada = finTemporada;
    }

   


    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getImporteD() {
        return importeD;
    }

    public void setImporteD(double importeD) {
        this.importeD = importeD;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getInicioTemporada() {
        return inicioTemporada;
    }

    public void setInicioTemporada(Date inicioTemporada) {
        this.inicioTemporada = inicioTemporada;
    }

    public Date getFinTemporada() {
        return finTemporada;
    }

    public void setFinTemporada(Date finTemporada) {
        this.finTemporada = finTemporada;
    }

    public Ciudad getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudad ciudades) {
        this.ciudades = ciudades;
    }
    
     public LocalDate getFechai() {
        return fechai;
    }

    public void setFechai(LocalDate fechai) {
        this.fechai = fechai;
    }

    public LocalDate getFechaf() {
        return fechaf;
    }

    public void setFechaf(LocalDate fechaf) {
        this.fechaf = fechaf;
    }

    @Override
    public String toString() {
        return "Alojamiento{" + "idAlojamiento=" + idAlojamiento + ", fechaI=" + fechaI + ", fechaF=" + fechaF + ", tipo=" + tipo + ", servicio=" + servicio + ", importeD=" + importeD + ", ciudad=" + ciudad + ", estado=" + estado + ", inicioTemporada=" + inicioTemporada + ", finTemporada=" + finTemporada + ", ciudades=" + ciudades + ", fechai=" + fechai + ", fechaf=" + fechaf + '}';
    }
   
}
