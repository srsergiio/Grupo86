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
        //aca tengo que llamar a la base de datos y traer el costoPasaje de la la tabla paquete segun el id del paquete
        return new pasajeData().getImporte(id); 
    }
    
    
    //
    
     public Pasaje getPasaje(int idPaquete) {
        Pasaje pasaje = null;
        String sql = "SELECT p.* FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                pasaje = new Pasaje();
                // Aquí asignas los valores a tu objeto Pasaje
                // por ejemplo: pasaje.setTipoTransporte(rs.getString("tipoTransporte"));
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
        
        return pasaje;
    }
    

    
    public String getTipoTransporte(int idPaquete) {
        String tipoTransporte = null;
        String sql = "SELECT p.tipoTransporte FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
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
    
        public Date getFechaIda(int idPaquete) {
        Date fechaIda = null;
        String sql = "SELECT p.fechaIda FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
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
        
            public Date getFechaVuelta(int idPaquete) {
        Date fechaVuelta = null;
        String sql = "SELECT p.fechaVuelta FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
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
            
        public int getEstado(int idPaquete) {
        int estado = 0;
        String sql = "SELECT p.estado FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                estado = rs.getInt("estado");
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
        
    public int getImporte(int idPaquete) {
        int importe = 0;
        String sql = "SELECT p.importe FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
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
    public int getCiudadOrigen(int idPaquete) {
        int ciudadOrigen = 0;
        String sql = "SELECT p.ciudadOrigen FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
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

    public int getCiudadDestino(int idPaquete) {
        int ciudadDestino = 0;
        String sql = "SELECT p.ciudadDestino FROM pasaje p JOIN paquete pa ON p.idPasaje = pa.costoPasaje WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
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
    
}
