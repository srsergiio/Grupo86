package Vista;
public class mainVista extends javax.swing.JFrame {
    public mainVista() {
        initComponents();
        //main 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cliente_ = new javax.swing.JMenu();
        Administracion = new javax.swing.JMenu();
        Paquetes = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        Cliente_.setText("Cliente");
        Cliente_.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                Cliente_MouseWheelMoved(evt);
            }
        });
        Cliente_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cliente_MouseClicked(evt);
            }
        });
        Cliente_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente_ActionPerformed(evt);
            }
        });
        jMenuBar1.add(Cliente_);

        Administracion.setText("Administracion");
        jMenuBar1.add(Administracion);

        Paquetes.setText("Paquetes");
        Paquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaquetesMouseClicked(evt);
            }
        });
        jMenuBar1.add(Paquetes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cliente_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cliente_ActionPerformed

     
    }//GEN-LAST:event_Cliente_ActionPerformed

    private void escritorioAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_escritorioAncestorRemoved

    }//GEN-LAST:event_escritorioAncestorRemoved

    private void Cliente_MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_Cliente_MouseWheelMoved
        // TODO add your handling code here:asdasd
        Despegar();
    }//GEN-LAST:event_Cliente_MouseWheelMoved

    private void PaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaquetesMouseClicked
        // TODO add your handling code here:
         VistaPaquete();
    }//GEN-LAST:event_PaquetesMouseClicked

    private void Cliente_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cliente_MouseClicked
        // TODO add your handling code here:
         Despegar();
    }//GEN-LAST:event_Cliente_MouseClicked

    public static void main(String args[]) {
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
    private javax.swing.JMenu Administracion;
    private javax.swing.JMenu Cliente_;
    private javax.swing.JMenu Paquetes;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

    public  void Despegar(){
        escritorio.removeAll();
        escritorio.repaint();
        Despegar despegar = new Despegar();
        
        despegar.setVisible(true);
        escritorio.add(despegar);
        escritorio.moveToFront(despegar);
    }
    
    public  void VistaPaquete(){
        escritorio.removeAll();
        escritorio.repaint();
        VistaPaquete VistaPaquete = new VistaPaquete();
        
        VistaPaquete.setVisible(true);
        escritorio.add(VistaPaquete);
        escritorio.moveToFront(VistaPaquete);
    }
}
