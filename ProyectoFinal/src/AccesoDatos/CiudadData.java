/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CiudadData  {
    private List<Ciudad> ciudades;
    private PasajeData pd;
    private static Connection con;
    
    public CiudadData() {
        ciudades = new ArrayList<>();  
        pd= new PasajeData();
         if (con == null) {
            con = Conexion.getConexion(); 
        }
    }
    
    public CiudadData(Connection con) {
        ciudades = new ArrayList<>();  
        pd= new PasajeData();
         if (con == null) {
            this.con = con; 
        }
    }
    public static List<Ciudad> listarCiudad(){
     
          List <Ciudad> ciudades =new ArrayList<>();
          try{
             String sql = "SELECT * FROM ciudad WHERE estado=1";
             PreparedStatement ps= con.prepareStatement(sql);
             ResultSet rs= ps.executeQuery();
          while (rs.next()){
                Ciudad ciudad= new Ciudad();
                ciudad.setIdCiudad(rs.getInt("idCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setProvincia(rs.getString("provincia"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setEstado(rs.getInt("estado"));
                ciudades.add(ciudad);
            }
               // ps.close();
            }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad"+ex.getMessage());
                    }
        return ciudades;
    }
    public ArrayList<Ciudad> listarCiudad2(){
    ArrayList <Ciudad> ciudades = new ArrayList<>();
    try{
        String sql = "SELECT * FROM ciudad WHERE estado=1";
        PreparedStatement ps= con.prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        while (rs.next()){
            Ciudad ciudad= new Ciudad();
            ciudad.setIdCiudad(rs.getInt("idCiudad"));
            ciudad.setNombre(rs.getString("nombre"));
            ciudad.setProvincia(rs.getString("provincia"));
            ciudad.setPais(rs.getString("pais"));
            ciudad.setEstado(rs.getInt("estado"));
            ciudades.add(ciudad);
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad"+ex.getMessage());
    }
    return ciudades;
}
    public void guardarCiudad(Ciudad ciudad){
         String sql= "INSERT INTO ciudad(nombre, provincia, pais,estado) VALUES (?,?,?,?)";
         try{
             PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getProvincia());
            ps.setString(3, ciudad.getPais());
            ps.setInt(4, ciudad.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                ciudad.setIdCiudad(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ciudad añadida con exito");
            }
//            ps.close(); 
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad "+ex.getMessage());
        }
    }
    public Ciudad obtenerCiudadPorNombre(String nombreCiudad) {
     Ciudad ciudad = null;
     try {
        String sql = "SELECT * FROM ciudad WHERE nombre = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreCiudad);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ciudad = new Ciudad();
            ciudad.setIdCiudad(rs.getInt("idCiudad"));
            ciudad.setNombre(rs.getString("nombre"));
            ciudad.setProvincia(rs.getString("provincia"));
            ciudad.setPais(rs.getString("pais"));
            ciudad.setEstado(rs.getInt("estado"));
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad: " + ex.getMessage());
    }

    return ciudad;
}     
    public  Ciudad buscarPorId(int id) {
         Ciudad ciudad=null;
         String sql= "SELECT nombre, provincia, pais FROM ciudad WHERE idCiudad = ? AND estado = 1";
         PreparedStatement ps=null;
          try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                ciudad= new Ciudad();
                ciudad.setIdCiudad(id);
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setProvincia(rs.getString("provincia"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setEstado(rs.getInt("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe la Ciudad");
                ps.close();
            } 
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad"+ex.getMessage());
                    }
        return ciudad;
    }     
    public List<Pasaje> obtenerTransportesPorDestino(Ciudad destino) {
        List<Pasaje> transportesDisponibles = new ArrayList<>();
        try{
        String sql = "SELECT * FROM pasaje";
        PreparedStatement ps= con.prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
           while (rs.next()){
        Pasaje pas = new Pasaje();
        pas.setIdPasaje(rs.getInt("idPasaje"));       
        String tipoTransporte = pd.getTipoTransporte(pas.getIdPasaje());
        pas.setTipoTransporte(tipoTransporte);
        transportesDisponibles.add(pas);
            }//ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad"+ex.getMessage());
        }
        return transportesDisponibles;
    }
    public List<Alojamiento> obtenerAlojamientosPorDestino(Ciudad destino) {
      List<Alojamiento> alojamientos = new ArrayList<>();
      try {
        String sql = "SELECT * FROM alojamiento WHERE ciudad = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, destino.getIdCiudad()); 
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Alojamiento alojamiento = new Alojamiento(); 
            alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
            alojamiento.setTipo(rs.getString("tipo"));
            alojamientos.add(alojamiento);
        }
      //  ps.close();
       } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento: " + ex.getMessage());
       }
       return alojamientos;
    }
    public List<Ciudad> obtenerCiudadesDisponibles() {
        List<Ciudad> ciudadesDisponibles = new ArrayList<>();
        String sql = "SELECT * FROM ciudad WHERE estado = true";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(rs.getInt("idCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setProvincia(rs.getString("provincia"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setEstado(rs.getInt("estado"));
                ciudadesDisponibles.add(ciudad);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
        }
        return ciudadesDisponibles;
    }
    public static int buscarIdPorNombre(String nombreCiudad) {
       int id = -1; 
       String sql = "SELECT idCiudad FROM ciudad WHERE nombre = ? AND estado = 1";
        try{
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, nombreCiudad);
           ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt("idCiudad");
        }
        //ps.close();
        }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar la ciudad: " + ex.getMessage());
        }
     return id;
    }
    public Ciudad buscarCiudadPorNombre(String nombreCiudad) {
    String sql = "SELECT * FROM ciudad WHERE nombre = ?";
    Ciudad ciudad = null;

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombreCiudad);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ciudad = new Ciudad();
            ciudad.setIdCiudad(rs.getInt("idCiudad"));
            ciudad.setNombre(rs.getString("nombre"));
            // Establece otros atributos de la entidad Ciudad si es necesario.
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "error al acceder a tabla ciudad");
    }

        return ciudad;
}
     public static void main(String []main){
     
     //test 
     CiudadData CiudadData = new CiudadData();
     List<Ciudad> Ciudad = CiudadData.listarCiudad();
     for( int i = 0 ; i<Ciudad.size() ; i++){
         System.out.println(Ciudad.get(i));
     }}
     
     

}

