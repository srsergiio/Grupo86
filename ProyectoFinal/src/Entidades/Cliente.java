package Entidades;
import Entidades.Ciudad;

public class Cliente {

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", dni=" + dni + ", CiudadOrigen" + CiudadOrigen + ", idCliente" + idCliente +'}';
    }

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, int dni, int telefono, int CiudadOrigen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
        this.CiudadOrigen = CiudadOrigen;
    }
    

    public Cliente(String nombre, int dni, int CiudadOrigen, int idCliente) {
        this.nombre = nombre;
        this.dni = dni;
        this.CiudadOrigen = CiudadOrigen;
        this.idCliente= idCliente;
    }
    
   private String nombre ,apellido,correo;
   private int dni,telefono;
   private int CiudadOrigen, idCliente;
    
}
