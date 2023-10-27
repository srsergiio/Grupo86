/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.Paquete;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
//public class paqueteData {
    
  //  public static ArrayList<int[]> getPaqueteData() {
//    ArrayList<paquete> lista = new ArrayList<>();
//    String sql = "SELECT idPaquete, costoEstadia, costoPasaje FROM paquete";
//    Connection con = Conexion.getConexion();
//    try {
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//        while(rs.next()){
//            //aca creo una entidad paquete.
//            int[] datos = new int[3];
//            Paquete paquete = new Paquete();
//            // asigno  sus valores
//            datos[0] = rs.getInt("idPaquete");
//            datos[1] = rs.getInt("costoEstadia");
//            datos[2] = rs.getInt("costoPasaje");
//            lista.add(datos);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    return lista;
//}

//    
//    
//    public static int getCostoEstadia(int id){
//        return 1/*alojamientoData.getImporte(id)*/;
//}
//    
//    public static int getCostoPasaje(int id){
//    return pasajeData.getImporte(id);
//    
//    //getTipoTransporte
//    
//    //getEstado
//    
//}
//    
//    
//    //
//}
