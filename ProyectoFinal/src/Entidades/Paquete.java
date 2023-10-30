package Entidades;
import Entidades.Ciudad;

public class Paquete {
    
    private int idPaquete;
    private int idAlojamiento;
    private int idPasaje;

    public Paquete() {
    }

    public Paquete(int idPaquete, int idAlojamiento, int idPasaje) {
        this.idPaquete = idPaquete;
        this.idAlojamiento = idAlojamiento;
        this.idPasaje = idPasaje;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    @Override
    public String toString() {
        return "Paquete{" + "idPaquete=" + idPaquete + ", idAlojamiento=" + idAlojamiento + ", idPasaje=" + idPasaje + '}';
    }
 
}