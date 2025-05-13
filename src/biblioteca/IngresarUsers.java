
package biblioteca;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class IngresarUsers extends javax.swing.JFrame {

    String Nombre, Apellido, Documento, Contraseña;
     private Biblioteca biblioteca;
     private Usuario usuario;
     
    
     
    public IngresarUsers() {
        initComponents();
         TxtNombre.setText("");
        TxtApellido.setText("");
        TxtDocumento.setText("");
        TxtContraseña.setText("");
        this.biblioteca = new Biblioteca();
        getRootPane().setDefaultButton(BtnRegister);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtApellido = new javax.swing.JTextField();
        TxtDocumento = new javax.swing.JTextField();
        jlabel = new javax.swing.JLabel();
        TxtContraseña = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        BtnRegister = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 0, 34, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Registrar Nuevo Usuario");
        jPanel1.add(titulo);
        titulo.setBounds(20, 30, 261, 32);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 110, 90, 24);
        jPanel1.add(TxtNombre);
        TxtNombre.setBounds(40, 140, 200, 29);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 180, 90, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Numero Documento");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(370, 110, 200, 24);

        TxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(TxtApellido);
        TxtApellido.setBounds(40, 230, 200, 30);
        jPanel1.add(TxtDocumento);
        TxtDocumento.setBounds(360, 140, 190, 31);

        jlabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jlabel.setForeground(new java.awt.Color(0, 0, 0));
        jlabel.setText("Contraseña");
        jPanel1.add(jlabel);
        jlabel.setBounds(390, 190, 129, 24);

        TxtContraseña.setText("jPasswordField1");
        jPanel1.add(TxtContraseña);
        TxtContraseña.setBounds(360, 230, 190, 30);

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(200, 10));
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(313, 39, 10, 350);

        BtnRegister.setBackground(new java.awt.Color(0, 153, 204));
        BtnRegister.setText("Registrar");
        BtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRegister);
        BtnRegister.setBounds(420, 340, 162, 38);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidoActionPerformed

    }//GEN-LAST:event_TxtApellidoActionPerformed

    private void BtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegisterActionPerformed
        GuardarUsuario();
    }//GEN-LAST:event_BtnRegisterActionPerformed

    public void GuardarUsuario()
    {
        Nombre = TxtNombre.getText();
        Apellido = TxtApellido.getText();
        Documento = TxtDocumento.getText();
        char[] passwordArray = TxtContraseña.getPassword();
        Contraseña = new String(passwordArray);


       if (Nombre == null || Nombre.isEmpty() || Apellido == null || Apellido.isEmpty() ||  Documento == null || Documento.isEmpty() ||Contraseña == null || Contraseña.isEmpty()) 
       {
     JOptionPane.showMessageDialog(this, "INGRESE TODOS LOS DATOS");
        return;  
     }
       
       else if (Documento.length() > 10 || Documento.length() < 7)
       {
           JOptionPane.showMessageDialog(this, "INGRESE UN DOCUMENTO VALIDO");
       }
       
       else if(Contraseña.length() < 5)
       {
           JOptionPane.showMessageDialog(this, "LA CONTRASEÑA NO PUEDE TENER MENOS DE 5 CARACTERES");
       }
       else
       {
           if (biblioteca.usuarioExiste(Documento)) {
            JOptionPane.showMessageDialog(this, "¡El usuario con ese documento ya está registrado!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }  
           else
           {
               try{

               Usuario nuevoUsuario = new Usuario(Nombre, Apellido, Documento,Contraseña);
               biblioteca.guardarUser(nuevoUsuario);
               JOptionPane.showMessageDialog(this, "Usuario guardado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
               FrmLogin Login = new FrmLogin();
               Login.setVisible(true);
               dispose();
              
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "No se pudo guardar nada"+ e , "Error"   ,  JOptionPane.INFORMATION_MESSAGE);
    }
           }
           
         
        
       }
  
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
            java.util.logging.Logger.getLogger(IngresarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarUsers().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegister;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JPasswordField TxtContraseña;
    private javax.swing.JTextField TxtDocumento;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
