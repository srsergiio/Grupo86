
package AccesoDatos;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class alojamientoData {
    private Connection con;
    

    //double o int getImporte(id);
    
    
    
    public alojamientoData() {
         this.con=Conexion.getConexion();
    }

  
    
    public List<Alojamiento> alojamientosDisponibles (Ciudad ciudad, Date ingreso, Date salida){
        
            List<Alojamiento> alojamientosDisponibles = new ArrayList<>();
          try {  
               java.sql.Date sqlfechaI = new java.sql.Date(ingreso.getTime());
               
               java.sql.Date sqlfechaF = new java.sql.Date(salida.getTime());

            String sql = "SELECT * FROM alojamiento WHERE ciudad =? AND fechaI => ? AND fechaF <= ?" ;
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, ciudad.getIdCiudad());
            ps.setDate(2, sqlfechaI);
            ps.setDate(3, sqlfechaF);
            
            
            ResultSet rs = ps.executeQuery();
              
              while (rs.next()){
                  Alojamiento alojamiento = new Alojamiento();
                  int idAlojamiento = rs.getInt("idAlojamiento");
                  alojamientosDisponibles.add(alojamiento);
              }
              ps.close();
        } catch (SQLException ex) {
              System.out.println("No se encontraron alojamientos"+ex);        }
          return alojamientosDisponibles;
        
    }
    
    public void alojamientoEstado (int idAlojamiento, boolean estado){
        try {
            String sql = "UPDATE alojamiento SET estado = ? WHERE idAlojamiento = ? ";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlojamiento);
            ps.setBoolean(2, estado);
            int filasActualizadas = ps.executeUpdate();
            
            if (filasActualizadas==1){
                System.out.println("Estado actualizado correctamente");
            }else{
                System.err.println("No se pudo actualizar el estado");
            }
        } catch (SQLException ex) {
            System.out.println("error"+ex);
        }
    }
       
        public Alojamiento detallesAlojamientoPorId(int idAlojamiento){
          Alojamiento alojamiento = null;
          
        try {
            //"SELECT a.* FROM alojamiento WHERE idAlojamiento = ?";
                     String sql =  "SELECT a.*, c.nombre AS ciudad, p.precioEstadia AS costo_estadia " +
                     "FROM alojamiento a " +
                     "INNER JOIN ciudad c ON a.ciudad = c.idCiudad " +
                     "INNER JOIN paquete p ON a.idAlojamiento = p.idAlojamiento " +
                     "WHERE a.idAlojamiento = ?";
                     
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, idAlojamiento);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int idAlojamientoEnBD = rs.getInt("idAlojamiento");
                java.sql.Date fechaI = rs.getDate("fecha ingreso");
                java.sql.Date fechaF = rs.getDate("fecha salida");
                String tipo = rs.getString ("Tipo de alojamiento");
                String servicio = rs.getString ("servicios");
                int importeD = rs.getInt("Importe estadia");
                int ciudad = rs.getInt("Destino");
                boolean estado = rs.getBoolean("estado");
                
                alojamiento = new Alojamiento(idAlojamiento, fechaI, fechaF, tipo, servicio, importeD, ciudad, estado);
            }       
            return alojamiento;
        } catch (SQLException ex) {
            System.out.println("error encontrando detalles del alojamiento"+ ex);
        }
            return null;
        }  
        
        
        public Alojamiento getAlojamiento(int id) {
    Alojamiento alojamiento = null;
    try {
        String sql = "SELECT * FROM alojamiento WHERE idAlojamiento = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idAlojamiento = rs.getInt("idAlojamiento");
            Date fichaIn = rs.getDate("fichaIn");
            Date fichaOn = rs.getDate("fichaOn");
            Boolean estado = rs.getBoolean("estado");
            String servicio = rs.getString("servicio");
            double importeDiario = rs.getDouble("importeDiario");
            Ciudad CiudadDest = null/* You need to fetch the Ciudad object based on its ID here */;
            String tipo = rs.getString("tipo");
            
            alojamiento = new Alojamiento(idAlojamiento, fichaIn, fichaOn, estado, servicio, importeDiario, CiudadDest, tipo);
        }
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al buscar el alojamiento: " + ex);
    }
    return alojamiento;
}
 

}

