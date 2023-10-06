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

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", dni=" + dni + '}';
    }

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, int dni, int telefono, Ciudad origen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
        this.origen = origen;
    }

    public Cliente(String nombre, int dni, Ciudad origen) {
        this.nombre = nombre;
        this.dni = dni;
        this.origen = origen;
    }
    
   private String nombre ,apellido,correo;
   private int dni,telefono;
   Ciudad origen;
    
}
