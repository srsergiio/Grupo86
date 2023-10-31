
package AccesoDatos;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class alojamientoData {
  private static Connection con;

    public alojamientoData() {
        this.con = Conexion.getConexion();
        if (con == null) {
            con = Conexion.getConexion(); 
        }
    }

    public alojamientoData(Connection conexion) {
        this.con = conexion; // Cambiar "con" por "conexion"
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
        public static void agregarAlojamiento(Alojamiento alojamiento)throws SQLException{
         String sql= "INSERT INTO alojamiento(fechaI, fechaF, tipo, servicio ,importeD, ciudad, estado) VALUES (?,?,?,?,?,?,?)";
         try{
             PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setDate(1, java.sql.Date.valueOf(alojamiento.getFechaI()));
             ps.setDate(2, java.sql.Date.valueOf(alojamiento.getFechaF()));
             ps.setString(3, alojamiento.getTipo());
             ps.setString(4, alojamiento.getServicio());
             ps.setDouble(5, alojamiento.getImporteDiario());
             if (alojamiento.getCiudad() != null) {
             ps.setInt(6, alojamiento.getCiudad().getIdCiudad());
             } else {
             
             }
  
             ps.setBoolean(7, alojamiento.getEstado());
             ps.executeUpdate();
             ResultSet rs= ps.getGeneratedKeys();
             if(rs.next()){
                alojamiento.setIdAlojamiento(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alojamiento agregado con exito");
            }
            ps.close(); 
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento "+ex.getMessage());
        }
        
    }
}

