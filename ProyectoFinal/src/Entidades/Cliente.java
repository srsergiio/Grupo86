package Entidades;
import Entidades.Ciudad;

public class Cliente {
   private String nombre ,apellido;
   private int dni;
   private int CiudadOrigen, idCliente;
   private Ciudad Ciudad;//extra

    public Cliente() {
    }

    public Cliente(Ciudad Ciudad) {
        this.Ciudad = Ciudad;
    }
    
    public Cliente(String nombre, String apellido, int dni, int CiudadOrigen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.CiudadOrigen = CiudadOrigen;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public int getCiudadOrigen() {
        return CiudadOrigen;
    }
    public void setCiudadOrigen(int CiudadOrigen) {
        this.CiudadOrigen = CiudadOrigen;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", CiudadOrigen=" + CiudadOrigen + ", idCliente=" + idCliente + '}';
    }

}
