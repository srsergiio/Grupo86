package Entidades;
import Entidades.Ciudad;
public class Pasaje {


    private int idPasaje;

    private String tipoTransporte;

    private double importe;

    private Ciudad nombreCiudadOrigen;

    private boolean estado;
    public Pasaje(){}
    public Pasaje(int idPasaje, String tipoTransporte, double importe, Ciudad nombreCiudadOrigen) {
        this.idPasaje = idPasaje;
        this.tipoTransporte = tipoTransporte;
        this.importe = importe;
        this.nombreCiudadOrigen = nombreCiudadOrigen;
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Ciudad getNombreCiudadOrigen() {
        return nombreCiudadOrigen;
    }

    public void setNombreCiudadOrigen(Ciudad nombreCiudadOrigen) {
        this.nombreCiudadOrigen = nombreCiudadOrigen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Pasaje{" + "idPasaje=" + idPasaje + ", tipoTransporte=" + tipoTransporte + ", importe=" + importe + ", nombreCiudadOrigen=" + nombreCiudadOrigen + ", estado=" + estado + '}';
    }  
}
