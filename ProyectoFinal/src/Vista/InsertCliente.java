/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import AccesoDatos.CiudadData;
import AccesoDatos.Conexion;
import AccesoDatos.ClienteData;
import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Cliente;
import Entidades.Paquete;
import Entidades.Pasaje;
import Entidades.Reserva;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import AccesoDatos.*;
import Entidades.*;

/**
 *
 * @author Administrador
 */
public class InsertCliente extends javax.swing.JInternalFrame {
    ArrayList<Object> BaseDatos ;
    ArrayList<Alojamiento> ListarAlojamiento ;
    ArrayList<Ciudad> ListarCiudad ;
    ArrayList<Cliente> ListarCliente ;
    ArrayList<Paquete> ListarPaquete ;
    ArrayList<Pasaje> ListarPasaje ;
    ArrayList<Reserva> ListarReserva ;
    private final Connection con;
    
    public InsertCliente(ArrayList<Object> BaseDatos) {
        this.BaseDatos = BaseDatos;
        ListarAlojamiento= ( ArrayList<Alojamiento>) this.BaseDatos.get(0);
        ListarCiudad= ( ArrayList<Ciudad>) this.BaseDatos.get(1);
        ListarCliente= ( ArrayList<Cliente>) this.BaseDatos.get(2);
        ListarPaquete= ( ArrayList<Paquete>) this.BaseDatos.get(3);
        ListarPasaje= ( ArrayList<Pasaje>) this.BaseDatos.get(4);
        ListarReserva= ( ArrayList<Reserva>) this.BaseDatos.get(5);
        initComponents();
        
        this.con=Conexion.getConexion(); 
        Connection conexion = Conexion.getConexion();
        ClienteData ClienteData = new ClienteData(con);
        CiudadData ciudadData = new CiudadData(con);
        
        
        DefaultTableModel ciudadTableModel = new DefaultTableModel();
        
        ciudadTableModel.addColumn("Nombre de la Ciudad");
        ciudadTableModel.addColumn("IdCiudad");
        ciudadTableModel.addColumn("Seleccionar");
        List<Ciudad> ciudadesDisponibles = ciudadData.listarCiudad(); 
        
        for (Ciudad ciudad : ciudadesDisponibles) {
        ciudadTableModel.addRow(new Object[]{ciudad.getNombre(), ciudad.getIdCiudad(), true});
        }
         jTableCd.setModel(ciudadTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        insert_Nombre_ = new javax.swing.JTextField();
        TituloNombre = new javax.swing.JLabel();
        TituloApellido = new javax.swing.JLabel();
        TituloDNI = new javax.swing.JLabel();
        insert_Apellido_ = new javax.swing.JTextField();
        insert_DNI_ = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        jButtonInsert = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCd = new javax.swing.JTable();
        TituloDNI1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        insert_Nombre_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_Nombre_ActionPerformed(evt);
            }
        });

        TituloNombre.setText("Ingrese su nombre :");

        TituloApellido.setText("Ingrese su apellido :");

        TituloDNI.setText("Ingrese su Dni :");

        insert_DNI_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_DNI_ActionPerformed(evt);
            }
        });

        Titulo.setText("Nuevo Cliente");

        jButtonInsert.setText("Insert");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jTableCd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableCd);

        TituloDNI1.setText("Ciudad Disponible :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonInsert)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Titulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloDNI)
                            .addComponent(TituloApellido)
                            .addComponent(TituloNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(insert_DNI_, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(insert_Apellido_)
                            .addComponent(insert_Nombre_, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGap(236, 236, 236))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloDNI1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 118, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert_Nombre_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TituloNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloApellido)
                    .addComponent(insert_Apellido_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloDNI)
                    .addComponent(insert_DNI_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(TituloDNI1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonInsert)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insert_Nombre_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_Nombre_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insert_Nombre_ActionPerformed

    private void insert_DNI_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_DNI_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insert_DNI_ActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
       String nombre = insert_Nombre_.getText();
    String apellido = insert_Apellido_.getText();
    String dniText = insert_DNI_.getText();
    Integer idCiudad = null;
    
    if (dniText.matches("\\d+")) {
        int dni = Integer.parseInt(dniText);

        
        for (int i = 0; i < jTableCd.getRowCount(); i++) {
            Boolean seleccionada = (Boolean) jTableCd.getValueAt(i, 2);
            if (seleccionada) {
            idCiudad = (int) jTableCd.getValueAt(i, 1);
            System.out.println("IdCiudad seleccionada: " + idCiudad); // Agrega esta línea para imprimir el valor
            break;
          }
        }
        
        if (idCiudad != null) {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDni(dni);
            cliente.setCiudadOrigen(idCiudad);

            try {
                ClienteData.agregarCliente(cliente);
                JOptionPane.showMessageDialog(this, "Cliente agregado correctamente");
                insert_Nombre_.setText("");
                insert_Apellido_.setText("");
                insert_DNI_.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una ciudad de origen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "El DNI debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonInsertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel TituloApellido;
    private javax.swing.JLabel TituloDNI;
    private javax.swing.JLabel TituloDNI1;
    private javax.swing.JLabel TituloNombre;
    private javax.swing.JTextField insert_Apellido_;
    private javax.swing.JTextField insert_DNI_;
    private javax.swing.JTextField insert_Nombre_;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableCd;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
