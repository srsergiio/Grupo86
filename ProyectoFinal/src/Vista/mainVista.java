package Vista;


import AccesoDatos.*;
import Entidades.*;

import java.util.ArrayList;
import java.util.HashMap;

public class mainVista extends javax.swing.JFrame {
    
ArrayList<Object> BaseDatos = new ArrayList<>();



 
    
    public mainVista() {
        initComponents();

        
        
        BaseDatos.add((ArrayList<Alojamiento>)new AlojamientoData().ListarAlojamientos());
        BaseDatos.add(new CiudadData().listarCiudad2());
        BaseDatos.add(new ClienteData().ListarClientes());
        BaseDatos.add(new PaqueteData().ListarPaqueteData());
        BaseDatos.add(new PasajeData().ListarPasajes());
        BaseDatos.add(new ReservaData().listarReserva());
        
        for(int i = 0 ;i<BaseDatos.size();i++){
            ArrayList<Object> temp = (ArrayList<Object>) BaseDatos.get(i);
            for(int j = 0 ;j<temp.size();j++){
                System.out.println(temp.get(j));
            }
        }
        Despegar();
        //main 
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Pantallas_ = new javax.swing.JMenu();
        Pantalla_Despegar_ = new javax.swing.JMenuItem();
        Pantalla_Paquetes_ = new javax.swing.JMenuItem();
        Pantalla_FormClientes_ = new javax.swing.JMenuItem();
        VistaReservas_ = new javax.swing.JMenuItem();
        insert_BD = new javax.swing.JMenu();
        Cliente = new javax.swing.JMenuItem();
        Pasaje = new javax.swing.JMenuItem();
        Ciudad = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 550));

        escritorio.setPreferredSize(new java.awt.Dimension(400, 400));
        escritorio.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                escritorioAncestorRemoved(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        Pantallas_.setText("Pantallas");
        Pantallas_.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                Pantallas_MouseWheelMoved(evt);
            }
        });
        Pantallas_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pantallas_MouseClicked(evt);
            }
        });
        Pantallas_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pantallas_ActionPerformed(evt);
            }
        });

        Pantalla_Despegar_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Pantalla_Despegar_.setText("Despegar");
        Pantalla_Despegar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pantalla_Despegar_ActionPerformed(evt);
            }
        });
        Pantallas_.add(Pantalla_Despegar_);

        Pantalla_Paquetes_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Pantalla_Paquetes_.setText("Paquete");
        Pantalla_Paquetes_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pantalla_Paquetes_MouseClicked(evt);
            }
        });
        Pantalla_Paquetes_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pantalla_Paquetes_ActionPerformed(evt);
            }
        });
        Pantallas_.add(Pantalla_Paquetes_);

        Pantalla_FormClientes_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Pantalla_FormClientes_.setText("Cliente");
        Pantalla_FormClientes_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pantalla_FormClientes_MouseClicked(evt);
            }
        });
        Pantalla_FormClientes_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pantalla_FormClientes_ActionPerformed(evt);
            }
        });
        Pantallas_.add(Pantalla_FormClientes_);

        VistaReservas_.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        VistaReservas_.setText("Reservas");
        VistaReservas_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VistaReservas_ActionPerformed(evt);
            }
        });
        Pantallas_.add(VistaReservas_);

        jMenuBar1.add(Pantallas_);

        insert_BD.setText("Insert");

        Cliente.setText("Cliente");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        insert_BD.add(Cliente);

        Pasaje.setText("Pasaje");
        insert_BD.add(Pasaje);

        Ciudad.setText("Ciudad");
        Ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadActionPerformed(evt);
            }
        });
        insert_BD.add(Ciudad);

        jMenuItem2.setText("Alojamiento");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        insert_BD.add(jMenuItem2);

        jMenuBar1.add(insert_BD);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void escritorioAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_escritorioAncestorRemoved

    }//GEN-LAST:event_escritorioAncestorRemoved

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void Pantallas_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pantallas_ActionPerformed

    }//GEN-LAST:event_Pantallas_ActionPerformed

    private void Pantallas_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pantallas_MouseClicked
        // borra este evento
    }//GEN-LAST:event_Pantallas_MouseClicked

    private void Pantallas_MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_Pantallas_MouseWheelMoved
        // guirar rueda del mouse sobre la etiqueta pantalla

    }//GEN-LAST:event_Pantallas_MouseWheelMoved

    private void VistaReservas_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VistaReservas_ActionPerformed

        //click submenu
        VistaReservas();
    }//GEN-LAST:event_VistaReservas_ActionPerformed

    private void Pantalla_FormClientes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pantalla_FormClientes_ActionPerformed
        // TODO add your handling code here:
        FormularioCliente();
    }//GEN-LAST:event_Pantalla_FormClientes_ActionPerformed

    private void Pantalla_FormClientes_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pantalla_FormClientes_MouseClicked
        FormularioCliente();
    }//GEN-LAST:event_Pantalla_FormClientes_MouseClicked

    private void Pantalla_Paquetes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pantalla_Paquetes_ActionPerformed
        // TODO add your handling code here:
        VistaPaquete();
    }//GEN-LAST:event_Pantalla_Paquetes_ActionPerformed

    private void Pantalla_Paquetes_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pantalla_Paquetes_MouseClicked

    }//GEN-LAST:event_Pantalla_Paquetes_MouseClicked

    private void Pantalla_Despegar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pantalla_Despegar_ActionPerformed
        // click en submenu

        Despegar();
    }//GEN-LAST:event_Pantalla_Despegar_ActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        // TODO add your handling code here:
        VistaInsertCliente();
    }//GEN-LAST:event_ClienteActionPerformed

    private void CiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadActionPerformed
        // TODO add your handling code here:
        
        VistaInsertCiudad();
    }//GEN-LAST:event_CiudadActionPerformed

    public static void main(String args[])  {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Ciudad;
    private javax.swing.JMenuItem Cliente;
    private javax.swing.JMenuItem Pantalla_Despegar_;
    private javax.swing.JMenuItem Pantalla_FormClientes_;
    private javax.swing.JMenuItem Pantalla_Paquetes_;
    private javax.swing.JMenu Pantallas_;
    private javax.swing.JMenuItem Pasaje;
    private javax.swing.JMenuItem VistaReservas_;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu insert_BD;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables

    public   void Despegar(){
        escritorio.removeAll();
        escritorio.repaint();
      
        Despegar despegar = new Despegar(BaseDatos ,escritorio);
        
        despegar.setVisible(true);
        escritorio.add(despegar);
        escritorio.moveToFront(despegar);
       
        
    }
    
     public  void VistaPaquete( ){
        escritorio.removeAll();
        escritorio.repaint();
        VistaPaquete VistaPaquete = new VistaPaquete(BaseDatos ,escritorio,new ArrayList<>());
        
        VistaPaquete.setVisible(true);
        escritorio.add(VistaPaquete);
        escritorio.moveToFront(VistaPaquete);
    }
    
     public  void FormularioCliente(){
        escritorio.removeAll();
        escritorio.repaint();
        GeneraReserva FormularioCliente = new GeneraReserva(BaseDatos,escritorio,0);
        
        FormularioCliente.setVisible(true);
        escritorio.add(FormularioCliente);
        escritorio.moveToFront(FormularioCliente);
    }
     
     public  void VistaReservas(){
        escritorio.removeAll();
        escritorio.repaint();
        VistaReservas VistaReservas = new VistaReservas(BaseDatos);
        
        VistaReservas.setVisible(true);
        escritorio.add(VistaReservas);
        escritorio.moveToFront(VistaReservas);
    }
    
   
    
    
    public  void VistaInsertCliente(){
        escritorio.removeAll();
        escritorio.repaint();
        InsertCliente InsertCliente = new InsertCliente(BaseDatos);
        
        InsertCliente.setVisible(true);
        escritorio.add(InsertCliente);
        escritorio.moveToFront(InsertCliente);
    }
    
    
    public  void VistaInsertCiudad(){
        escritorio.removeAll();
        escritorio.repaint();
        InsertCiudad InsertCiudad = new InsertCiudad(BaseDatos);
        
        InsertCiudad.setVisible(true);
        escritorio.add(InsertCiudad);
        escritorio.moveToFront(InsertCiudad);
    }
}
