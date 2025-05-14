
package biblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FrmLogin extends javax.swing.JFrame {
 String Documento, Contraseña;
 private Biblioteca biblioteca;
 private Usuario usuario;
 private Sesion sesion;
 private int idUsuario;
 Cconexion conexion = new Cconexion();
    
     
    public FrmLogin() {
        initComponents();
        TxtDocumento.setText("");
        TxtContraseña.setText("");
        this.biblioteca = new Biblioteca();
        this.sesion = new Sesion();
        getRootPane().setDefaultButton(BtnIngresar);
        interactuar();
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtDocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BtnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnNuevoUsuario = new javax.swing.JButton();
        TxtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingrese su documento");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingrese su contraseña");

        BtnIngresar.setBackground(new java.awt.Color(0, 153, 255));
        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/prestamo.gif"))); // NOI18N
        jLabel3.setText("jLabel3");

        BtnNuevoUsuario.setBackground(new java.awt.Color(0, 153, 255));
        BtnNuevoUsuario.setText("Registrar Usuario");
        BtnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoUsuarioActionPerformed(evt);
            }
        });

        TxtContraseña.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(TxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(BtnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnNuevoUsuario)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoUsuarioActionPerformed
            IngresarUsers newUser = new IngresarUsers();
            newUser.setVisible(true);
            dispose();
    }//GEN-LAST:event_BtnNuevoUsuarioActionPerformed

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        Documento = TxtDocumento.getText();
        char[] passwordArray = TxtContraseña.getPassword();
        Contraseña = new String(passwordArray);
        
        if(Documento.isEmpty() || Contraseña.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "INGRESE LOS DATOS");
            
        }
        else
        {
                
         String SQLquery = "CALL validar_usuario(?,?)";
         PreparedStatement  ps = null;
     try {
         ps = conexion.estableceConexcion().prepareStatement(SQLquery);
         ps.setString(1, Documento);
         ps.setString(2, Contraseña);
         ResultSet rs = ps.executeQuery();

        if (rs.next()) { 
         int rol = rs.getInt("idFK_rol");
         
         
         if(rol==1)
         {
             
             FrmBiblioteca inicioAdmin = new FrmBiblioteca();
             inicioAdmin.setVisible(true);
             idUsuario = rs.getInt("id"); 
             Sesion.idUsuario = idUsuario;
             System.out.println("Usuario logueado ID: " + Sesion.idUsuario);
             dispose();
         }
         else if(rol==2)
         {
            
             FrmDefaullt inicio = new FrmDefaullt();
             inicio.setVisible(true);
             int idUsuario = rs.getInt("id"); 
             Sesion.idUsuario = idUsuario;
             System.out.println("Usuario logueado ID: " + Sesion.idUsuario);
             dispose();
            
         }
         else if(rol==3)
         {
             FrmUsurios  user = new FrmUsurios();
             user.setVisible(true);
             int idUsuario = rs.getInt("id"); 
             Sesion.idUsuario = idUsuario;
             System.out.println("Usuario logueado ID: " + Sesion.idUsuario);
             dispose();
         }
         
         else
         {
             JOptionPane.showMessageDialog(this, "ERROR, INTENTE NUEVAMENTE");
         }
        
        } else {
        JOptionPane.showMessageDialog(this, "DATOS INCORRECTOS, INGRESE LOS DATOS DE MANERA CORRECTA O REGISTRESE");
      }

         
     } catch (SQLException ex) {
         Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
     }
         
        } 
    }//GEN-LAST:event_BtnIngresarActionPerformed
    
    public void interactuar()
    {
        TxtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
            TxtContraseña.requestFocus(); // pasa el foco al campo de contraseña
        }
    }
});
        TxtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
            TxtDocumento.requestFocus(); // vuelve al campo documento
        }
    }
});

        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JButton BtnNuevoUsuario;
    private javax.swing.JPasswordField TxtContraseña;
    private javax.swing.JTextField TxtDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
