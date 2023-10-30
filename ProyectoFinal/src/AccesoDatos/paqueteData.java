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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
            paquete.setIdAlojamiento(rs.getInt("idAlojamiento"));
            paquete.setIdPasaje(rs.getInt("idPasaje"));
            lista.add(paquete);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }// finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    return lista;
}

}
