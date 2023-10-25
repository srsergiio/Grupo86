/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.Paquete;
import Entidades.Ciudad;
import AccesoDatos.CiudadData;
import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class paqueteData {
    Connection con ;
    public paqueteData() {
       this.con = Conexion.getConexion();
    }
    
    
    
    
    public ArrayList<Paquete> getPaqueteData() {
    ArrayList<Paquete> lista = new ArrayList<>();
    String sql = "SELECT idPaquete, costoEstadia, costoPasaje FROM paquete";
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            //aca creo una entidad paquete.
     
            Paquete paquete = new Paquete();
            // asigno  sus valores
            paquete.setIdPaquete(rs.getInt("idPaquete"));
            paquete.setOrigen(new CiudadData().buscarPorId(new pasajeData().getCiudadOrigen(rs.getInt("costoPasaje"))));
            paquete.setDestino(new CiudadData().buscarPorId(new pasajeData().getCiudadDestino(rs.getInt("costoPasaje"))));
            paquete.setAlojamiento( new alojamientoData().getAlojamiento(rs.getInt("costoPasaje")));
            paquete.setPasaje(/*(Pasaje)*/new pasajeData().getPasajeData(rs.getInt("costoPasaje")));
            lista.add(paquete);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if(con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return lista;
}

    
    
    public  int getCostoEstadia(int id){
        return 1/*alojamientoData.getImporte(id)*/;
}
    
    public  int getCostoPasaje(int id){
        return new pasajeData().getImporte(id); 
    }
    
    
    //
}
