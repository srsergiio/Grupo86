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
import java.util.Date;

public class pasajeData {
    
    

    public static void getPasajeData(int id){
        String sql="SELECT * FROM `pasaje` WHERE `idPasaje`="+id;
        Connection con=Conexion.getConexion();
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println("idPasaje: " + rs.getInt("idPasaje"));
            // Añade aquí más campos según sea necesario
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
}

public static String getTipoTransporte(int id){
    String sql="SELECT tipoTransporte FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    String tipoTransporte = null;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            tipoTransporte = rs.getString("tipoTransporte");
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
    return tipoTransporte;
}
public static Date getFechaIda(int id){
    String sql="SELECT fechaIda FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    Date fechaIda = null;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            fechaIda = rs.getDate("fechaIda");
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
    return fechaIda;
}

public static Date getFechaVuelta(int id){
    String sql="SELECT fechaVuelta FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    Date fechaVuelta = null;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            fechaVuelta = rs.getDate("fechaVuelta");
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
    return fechaVuelta;
}

public static boolean getEstado(int id){
    String sql="SELECT estado FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    boolean estado = false;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            estado = rs.getBoolean("estado");
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
    return estado;
}


public static int getImporte(int id){
    String sql="SELECT importe FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    int importe = 0;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            importe = rs.getInt("importe");
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
    return importe;
}

public static int getCiudadOrigen(int id){
    String sql="SELECT ciudadOrigen FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    int ciudadOrigen = 0;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            ciudadOrigen = rs.getInt("ciudadOrigen");
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
    return ciudadOrigen;
}

 public static int getCiudadDestino(int id){
    String sql="SELECT ciudadDestino FROM `pasaje` WHERE `idPasaje`="+id;
    Connection con=Conexion.getConexion();
    int ciudadDestino = 0;
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            ciudadDestino = rs.getInt("ciudadDestino");
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
    return ciudadDestino;
}
 
 public static void setCiudadDestino(int id, int nuevaCiudadDestino){
    String sql="UPDATE `pasaje` SET `ciudadDestino` = ? WHERE `idPasaje` = ?";
    Connection con=Conexion.getConexion();
    try {
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, nuevaCiudadDestino);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if(con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
 

    public static void main (String []main){
      //sdasda  getPasajeData(27);
       System.out.println (getTipoTransporte(27));
    }
}
