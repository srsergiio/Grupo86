/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class reservaData {
    private List<Reserva> reservas;
    private static Connection con;
   
    public reservaData(){
        reservas = new ArrayList<>(); 
         if (con == null) {
            con = Conexion.getConexion(); 
        }
    }
  
     public static List<Reserva> listarReserva(){
          List <Reserva> reservas =new ArrayList<>();
          try{
             String sql = "SELECT * FROM reserva";
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs= ps.executeQuery();
          while (rs.next()){
                Reserva reserva= new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setIdCliente(rs.getInt("idCliente"));
                reserva.setIdPaquete(rs.getInt("idPaquete"));
                reserva.setFechaReserva(rs.getDate("fechaReserva"));
                reserva.setFechaViaje(rs.getInt("fechaViaje"));
                reservas.add(reserva);
            }
                ps.close();
            }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva"+ex.getMessage());
                    }
        return reservas;
    }
}
