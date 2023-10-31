/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class PasajeData {
    private final Connection con;
    
    public PasajeData() {
         this.con=Conexion.getConexion();
    }
    
    public ArrayList<Pasaje> ListarPasajes() {
        String sql = "SELECT * FROM `pasaje`";
        ArrayList<Pasaje> pasajes = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                pasaje.setTipoTransporte(rs.getString("tipoTransporte"));
                pasaje.setFechaIda(rs.getDate("fechaIda"));
                pasaje.setFechaVuelta(rs.getDate("fechaVuelta"));
                pasaje.setEstado(rs.getInt("estado"));
                pasaje.setImporte(rs.getDouble("importe"));
                pasaje.setCiudadOrigen(rs.getInt("ciudadOrigen"));
                pasaje.setCiudadDestino(rs.getInt("ciudadDestino"));
                pasajes.add(pasaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            try {
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
        return pasajes;
    }


    public  Pasaje getPasajeData(int id){
        String sql="SELECT * FROM `pasaje` WHERE `idPasaje`="+id;
         Pasaje pasaje= new Pasaje();
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
           
            
            pasaje.setIdPasaje(rs.getInt("idPasaje"));
            pasaje.setTipoTransporte(rs.getString("tipoTransporte"));
            pasaje.setFechaIda(rs.getDate("fechaIda"));
            pasaje.setFechaVuelta(rs.getDate("fechaVuelta"));
            pasaje.setEstado(rs.getInt("estado"));
            pasaje.setImporte(rs.getDouble("importe"));
            pasaje.setCiudadOrigen(rs.getInt("ciudadOrigen"));
            pasaje.setCiudadDestino(rs.getInt("ciudadDestino"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    return pasaje;
}
    
    

public  String getTipoTransporte(int id){
    String sql="SELECT tipoTransporte FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    String tipoTransporte = null;
    try {
        Statement stmt = this.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            tipoTransporte = rs.getString("tipoTransporte");
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    }// finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    return tipoTransporte;
}
public  Date getFechaIda(int id){
    String sql="SELECT fechaIda FROM `pasaje` WHERE `idPasaje`="+id;
    Date fechaIda = null;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            fechaIda = rs.getDate("fechaIda");
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    return fechaIda;
}

public  Date getFechaVuelta(int id){
    String sql="SELECT fechaVuelta FROM `pasaje` WHERE `idPasaje`="+id;
    Date fechaVuelta = null;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            fechaVuelta = rs.getDate("fechaVuelta");
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    return fechaVuelta;
}

public  boolean getEstado(int id){
    String sql="SELECT estado FROM `pasaje` WHERE `idPasaje`="+id;
    boolean estado = false;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            estado = rs.getBoolean("estado");
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    return estado;
}


public  int getImporte(int id){
    String sql="SELECT importe FROM `pasaje` WHERE `idPasaje`="+id;   
    int importe = 0;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            importe = rs.getInt("importe");
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    return importe;
}

public  int getCiudadOrigen(int id){
    String sql="SELECT ciudadOrigen FROM `pasaje` WHERE `idPasaje`="+id;
    //Connection con =Conexion.getConexion();
    int ciudadOrigen = 0;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            ciudadOrigen = rs.getInt("ciudadOrigen");
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
        // try {
        //     if(con != null) con.close();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }
    return ciudadOrigen;
}


 public  int getCiudadDestino(int id){
    String sql="SELECT ciudadDestino FROM `pasaje` WHERE `idPasaje`="+id;
    int ciudadDestino = 0;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            ciudadDestino = rs.getInt("ciudadDestino");
        }
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    return ciudadDestino;
}
 
 public  void setCiudadDestino(int id, int nuevaCiudadDestino){
    String sql="UPDATE `pasaje` SET `ciudadDestino` = ? WHERE `idPasaje` = ?";
    try {
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, nuevaCiudadDestino);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
//    } finally {
//        try {
//            if(con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
 
 public static Pasaje getPasje(int id){
     
     
     return new Pasaje();
 }
 
 

    public static void main(String[] args) {
        PasajeData pd = new PasajeData();
        ArrayList<Pasaje> pasajes = pd.ListarPasajes();
        for (Pasaje pasaje : pasajes) {
            System.out.println(pasaje);
        }
    }


   
}
