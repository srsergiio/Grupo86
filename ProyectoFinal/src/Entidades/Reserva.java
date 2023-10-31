/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Reserva {
    private int idReserva, idCliente, idPaquete;

    
    public Reserva(){
        
    }

    public Reserva(int idReserva, int idCliente, int idPaquete) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;

    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idCliente=" + idCliente + ", idPaquete=" + idPaquete + '}';
    }



    
}
