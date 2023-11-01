/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Cliente;
import Entidades.Paquete;
import Entidades.Pasaje;
import Entidades.Reserva;
import java.util.ArrayList;
import AccesoDatos.*;
import Entidades.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Administrador
 */
public class InsertCiudad extends javax.swing.JInternalFrame {
    ArrayList<Object> BaseDatos ;
    ArrayList<Alojamiento> ListarAlojamiento ;
    ArrayList<Ciudad> ListarCiudad ;
    ArrayList<Cliente> ListarCliente ;
    ArrayList<Paquete> ListarPaquete ;
    ArrayList<Pasaje> ListarPasaje ;
    ArrayList<Reserva> ListarReserva ;
    /**
     * Creates new form InsertCiudad
     */
    public InsertCiudad(ArrayList<Object> BaseDatos) {
        this.BaseDatos = BaseDatos;
        ListarAlojamiento= ( ArrayList<Alojamiento>) this.BaseDatos.get(0);
        ListarCiudad= ( ArrayList<Ciudad>) this.BaseDatos.get(1);
        ListarCliente= ( ArrayList<Cliente>) this.BaseDatos.get(2);
        ListarPaquete= ( ArrayList<Paquete>) this.BaseDatos.get(3);
        ListarPasaje= ( ArrayList<Pasaje>) this.BaseDatos.get(4);
        ListarReserva= ( ArrayList<Reserva>) this.BaseDatos.get(5);
        initComponents();
        Estadojbc();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo_ciudad = new javax.swing.JLabel();
        Insert_Ciudad_ = new javax.swing.JTextField();
        Titulo_provincia = new javax.swing.JLabel();
        Insert_Provincia_ = new javax.swing.JTextField();
        Titulo_pais = new javax.swing.JLabel();
        Insert_Pais_ = new javax.swing.JTextField();
        Titulo_ = new javax.swing.JLabel();
        Insert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Estado = new javax.swing.JComboBox<>();

        Titulo_ciudad.setText("Ingrese Ciudad:");

        Titulo_provincia.setText("Ingrese Provincia:");

        Titulo_pais.setText("Ingrese Pais:");

        Titulo_.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Titulo_.setText("CargarCiudad");

        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        jLabel1.setText("Estado:");

        Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo_)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Titulo_provincia)
                            .addComponent(Titulo_pais)
                            .addComponent(Titulo_ciudad)
                            .addComponent(jLabel1))
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Insert_Ciudad_)
                            .addComponent(Insert_Provincia_)
                            .addComponent(Insert_Pais_, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo_)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert_Ciudad_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Titulo_ciudad))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo_provincia)
                    .addComponent(Insert_Provincia_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert_Pais_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Titulo_pais))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(Insert)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:
      String nombre = Insert_Ciudad_.getText();
      String provincia = Insert_Provincia_.getText();
      String pais = Insert_Pais_.getText();
      String estadoCiudad = (String) Estado.getSelectedItem();
      int estado = estadoCiudad.equals("1") ? 1 : 0;

      Ciudad nuevaCiudad = new Ciudad();
      nuevaCiudad.setNombre(nombre);
      nuevaCiudad.setProvincia(provincia);
      nuevaCiudad.setPais(pais);
      nuevaCiudad.setEstado(estado);

      CiudadData ciudadData = new CiudadData(Conexion.getConexion());

      ciudadData.guardarCiudad(nuevaCiudad);

    }//GEN-LAST:event_InsertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Estado;
    private javax.swing.JButton Insert;
    private javax.swing.JTextField Insert_Ciudad_;
    private javax.swing.JTextField Insert_Pais_;
    private javax.swing.JTextField Insert_Provincia_;
    private javax.swing.JLabel Titulo_;
    private javax.swing.JLabel Titulo_ciudad;
    private javax.swing.JLabel Titulo_pais;
    private javax.swing.JLabel Titulo_provincia;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

  private void Estadojbc(){
      DefaultComboBoxModel<String> estadoModel = new DefaultComboBoxModel<>();
      estadoModel.addElement("0"); 
      estadoModel.addElement("1"); 
      Estado.setModel(estadoModel);       
   }




}


