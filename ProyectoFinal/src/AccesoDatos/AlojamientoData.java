
package AccesoDatos;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class AlojamientoData {
    private static Connection con;
     private List<Alojamiento> alojamientos;

    //double o int getImporte(id);
    
    
    
    public AlojamientoData() {
         this.con=Conexion.getConexion();
         alojamientos=new ArrayList<>();;
         this.con = Conexion.getConexion();
         
        if (con == null) {
            con = Conexion.getConexion(); 
        }
         
    }
     
    
    public AlojamientoData(Connection conexion) {
        this.con = conexion; // Cambiar "con" por "conexion"
    }

  public List<Alojamiento> ListarAlojamientos() {
        String sql = "SELECT * FROM `alojamiento`";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Alojamiento alojamiento = new Alojamiento();
 
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setFechaI(rs.getDate("fechaI"));
                alojamiento.setFechaF(rs.getDate("fechaF"));
                alojamiento.setTipo(rs.getString ("tipo"));
                alojamiento.setServicio(rs.getString ("servicio"));
                alojamiento.setImporteD(rs.getDouble("importeD"));
                alojamiento.setCiudad(rs.getInt("ciudad"));
                alojamiento.setEstado(rs.getInt("estado"));
                alojamiento.setInicioTemporada(rs.getDate("inicioTemporada"));
                alojamiento.setFinTemporada(rs.getDate("finTemporada"));
                
                alojamientos.add(alojamiento);
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
        return alojamientos;
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
//              ps.close();
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
                java.sql.Date fechaI = rs.getDate("fechaI");
                java.sql.Date fechaF = rs.getDate("fechaF");
                String tipo = rs.getString ("tipo");
                String servicio = rs.getString ("servicio");
                double importeD = rs.getInt("importeD");
                int ciudad = rs.getInt("ciudad");
                int estado = rs.getInt("estado");
                Date inicioTemporada = rs.getDate("inicioTemporada");
                Date finTemporada = rs.getDate("finTemporada");
                
                alojamiento = new Alojamiento( idAlojamientoEnBD, fechaI,  fechaF, tipo, servicio,  importeD, ciudad,  estado,  inicioTemporada,  finTemporada);
            }       
            return alojamiento;
        } catch (SQLException ex) {
            System.out.println("error encontrando detalles del alojamiento"+ ex);
        }
            return null;
        }  
        
        
        public Alojamiento getAlojamiento(int id) {
    Alojamiento alojamiento = null ;
    try {
        String sql = "SELECT * FROM alojamiento WHERE idAlojamiento = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
           int idAlojamientoEnBD = rs.getInt("idAlojamiento");
                java.sql.Date fechaI = rs.getDate("fechaI");
                java.sql.Date fechaF = rs.getDate("fechaF");
                String tipo = rs.getString ("tipo");
                String servicio = rs.getString ("servicio");
                double importeD = rs.getInt("importeD");
                int ciudad = rs.getInt("ciudad");
                int estado = rs.getInt("estado");
                Date inicioTemporada = rs.getDate("inicioTemporada");
                Date finTemporada = rs.getDate("finTemporada");
          
                alojamiento = new Alojamiento( idAlojamientoEnBD, fechaI,  fechaF, tipo, servicio,  importeD, ciudad,  estado,  inicioTemporada,  finTemporada);
        }
//        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al buscar el alojamiento: " + ex);
    }
    return alojamiento;
}
 public static void main (String [] main){
     //test 
     AlojamientoData alojamientoData = new AlojamientoData();
     List<Alojamiento> listalojamientoData = alojamientoData.ListarAlojamientos();
     for( int i = 0 ; i<listalojamientoData.size() ; i++){
         System.out.println(listalojamientoData.get(i));
     }
 }
  public static void agregarAlojamiento(Alojamiento alojamiento)throws SQLException{
         String sql= "INSERT INTO alojamiento(fechaI, fechaF, tipo, servicio ,importeD, ciudad, estado) VALUES (?,?,?,?,?,?,?)";
         try{
             PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setDate(1, java.sql.Date.valueOf(alojamiento.getFechai()));
             ps.setDate(2, java.sql.Date.valueOf(alojamiento.getFechaf()));
             ps.setString(3, alojamiento.getTipo());
             ps.setString(4, alojamiento.getServicio());
             ps.setDouble(5, alojamiento.getImporteD());
             if (alojamiento.getCiudades() != null) {
             ps.setInt(6, alojamiento.getCiudades().getIdCiudad());
             } else {           
             }
             ps.setInt(7, alojamiento.getEstado());
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

