/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Ciudad;
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class clienteData {
    private static Connection con;
    private List<Cliente> clientes;
    private CiudadData cd= new CiudadData();
    
    public clienteData() {
        clientes = new ArrayList<>();
           
        if (con == null) {
            con = Conexion.getConexion(); 
        }
    }
    public clienteData(Connection conexion) {
        this.con = conexion;
    }
    
     public static void agregarCliente(Cliente nuevoCliente)throws SQLException {
           String sql= "INSERT INTO cliente(nombre, apellido, dni, CiudadOrigen) VALUES (?,?,?,?)";
           try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nuevoCliente.getNombre());
            ps.setString(2, nuevoCliente.getApellido());
            ps.setInt(3, nuevoCliente.getDni());
            ps.setInt(4, nuevoCliente.getCiudadOrigen());
            
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                nuevoCliente.setIdCliente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cliente agregado");  
            }
            ps.close(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente"+ex.getMessage());
        }
     }
     
     public void actualizarCliente(Cliente cliente){
         String sql="UPDATE cliente SET nombre=?,apellido=?,dni=?,CiudadOrigen=? WHERE idCliente=?";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            ps.setInt(4, cliente.getCiudadOrigen());
            ps.setInt(5, cliente.getIdCliente());
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Cliente actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "No existe el cliente");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Eror al acceder a la tabla cliente"+ex.getMessage());
        }
    }
     
     public Cliente obtenerClientePorId(int id){
        Cliente cliente=null;
        String sql= "SELECT nombre, apelllido, dni, CiudadOrigen FROM cliente WHERE idCliente = ? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                cliente= new Cliente();
                cliente.setIdCliente(id);
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setCiudadOrigen(rs.getInt("CiudadOrigen"));
                cliente.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el cliente");
                ps.close();
            }
            
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente"+ex.getMessage());
                    }
        return cliente;
         
     }
    public List<Ciudad> obtenerCiudadesOrigenDisponibles() {
        List<Ciudad> ciudadesOrigenDisponibles = new ArrayList<>();
        CiudadData ciudadData = new CiudadData(); // Instancia de CiudadData para acceder al método listarCiudad
        try {
        // Obtener todas las ciudades disponibles usando el método listarCiudad de CiudadData
        List<Ciudad> ciudades = ciudadData.listarCiudad();
        ciudadesOrigenDisponibles.addAll(ciudades);
        }catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente" + ex.getMessage());
     }
    return ciudadesOrigenDisponibles;
    }
 
}
