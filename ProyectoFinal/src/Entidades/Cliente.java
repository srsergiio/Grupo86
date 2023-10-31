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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
   
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", dni=" + dni + ", CiudadOrigen" + CiudadOrigen + ", idCliente" + idCliente +", estado=" + estado + '}';
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
    

    public Cliente(String nombre, int dni, int CiudadOrigen, int idCliente, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.CiudadOrigen = CiudadOrigen;
        this.idCliente= idCliente;
        this.estado= estado;
    }

    public Cliente(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
   private String nombre ,apellido,correo;
   private int dni,telefono;
   private int CiudadOrigen, idCliente;
   private boolean estado;
   private Ciudad ciudad;
}
