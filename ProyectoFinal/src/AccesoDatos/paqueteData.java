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
    
    public  int getCostoPaquete(int id){
        return get_alojamiento_ImporteD(id)+get_pasaje_Importe(id); 
    }
    
    public int get_ID_Pasaje(int idPaquete) {
        int costoPasaje = 0;
        String sql = "SELECT costoPasaje FROM paquete WHERE idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                costoPasaje = rs.getInt("costoPasaje");
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
        
        return costoPasaje;
    } 
        
    public int get_ID_alojamiento(int idPaquete) {
        int costoEstadia = 0;
        String sql = "SELECT costoEstadia FROM paquete WHERE idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                costoEstadia = rs.getInt("costoEstadia");
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
        
        return costoEstadia;
    }    
    
    public Pasaje get_pasaje_Pasaje(int idPaquete) {
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
    
    public String get_pasaje_TipoTransporte(int idPaquete) {
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
    
    public Date get_pasaje_FechaIda(int idPaquete) {
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
        
    public Date get_pasaje_FechaVuelta(int idPaquete) {
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
            
    public int get_pasaje_Estado(int idPaquete) {
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
        
    public int get_pasaje_Importe(int idPaquete) {
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
    
    public int get_pasaje_CiudadOrigen(int idPaquete) {
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

    public int get_pasaje_CiudadDestino(int idPaquete) {
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
    
    public Date get_alojamiento_FechaI(int idPaquete) {
        Date fechaI = null;
        String sql = "SELECT a.fechaI FROM alojamiento a JOIN paquete pa ON a.idAlojamiento = pa.costoEstadia WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                fechaI = rs.getDate("fechaI");
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
        
        return fechaI;
    }
        
    public Date get_alojamiento_FechaF(int idPaquete) {
        Date fechaF = null;
        String sql = "SELECT a.fechaF FROM alojamiento a JOIN paquete pa ON a.idAlojamiento = pa.costoEstadia WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                fechaF = rs.getDate("fechaF");
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
        
        return fechaF;
    }
    
    public String get_alojamiento_Tipo(int idPaquete) {
        String tipo = null;
        String sql = "SELECT a.tipo FROM alojamiento a JOIN paquete pa ON a.idAlojamiento = pa.costoEstadia WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                tipo = rs.getString("tipo");
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
        
        return tipo;
    }
    
    public String get_alojamiento_Servicio(int idPaquete) {
        String servicio = null;
        String sql = "SELECT a.servicio FROM alojamiento a JOIN paquete pa ON a.idAlojamiento = pa.costoEstadia WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                servicio = rs.getString("servicio");
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
        
        return servicio;
    }
        
    public int get_alojamiento_ImporteD(int idPaquete) {
        int importeD = 0;
        String sql = "SELECT a.importeD FROM alojamiento a JOIN paquete pa ON a.idAlojamiento = pa.costoEstadia WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                importeD = rs.getInt("importeD");
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
        
        return importeD;
    }
    
    public int get_alojamiento_Estado(int idPaquete) {
        int estado = 0;
        String sql = "SELECT a.estado FROM alojamiento a JOIN paquete pa ON a.idAlojamiento = pa.costoEstadia WHERE pa.idPaquete = ?";
        
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
    
    public int get_alojamiento_Ciudad(int idPaquete) {
        int ciudad = 0;
        String sql = "SELECT a.ciudad FROM alojamiento a JOIN paquete pa ON a.idAlojamiento = pa.costoEstadia WHERE pa.idPaquete = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPaquete);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                ciudad = rs.getInt("ciudad");
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
        
        return ciudad;
    }
}
