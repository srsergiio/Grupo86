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
public class CiudadData  extends Algoridmo {
    private List<Ciudad> ciudades;
    private final Connection con;
    private pasajeData pd;
     
     public CiudadData() {
        this.con=Conexion.getConexion(); 
        ciudades = new ArrayList<>();  
        pd= new pasajeData();
    }
     public void guardarCiudad(Ciudad ciudad){
         String sql= "INSERT INTO ciudad(nombre, provincia, pais, estado) VALUES (?,?,?,?,?)";
         try{
             PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getProvincia());
            ps.setString(3, ciudad.getPais());
            ps.setBoolean(4, ciudad.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                ciudad.setIdCiudad(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ciudad añadida con exito");
            }
            ps.close(); 
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
            ciudad.setEstado(rs.getBoolean("estado"));
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad: " + ex.getMessage());
    }

    return ciudad;
}     
     public Ciudad buscarPorId(int id) {
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
                ciudad.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe la Ciudad");
                ps.close();
            } 
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad"+ex.getMessage());
                    }
        return ciudad;
    }
     
     
     public List<Ciudad> listarCiudad(){
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
                ciudad.setEstado(true);
                ciudades.add(ciudad);
            }
                ps.close();
            }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad"+ex.getMessage());
                    }
        return ciudades;
    }
     
      // Método para obtener transportes disponibles en una ciudad
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
            }ps.close();
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
        ps.close();
       } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento: " + ex.getMessage());
       }
       return alojamientos;
    }

    
       
}
