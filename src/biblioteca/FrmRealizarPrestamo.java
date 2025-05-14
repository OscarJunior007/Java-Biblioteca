
package biblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class FrmRealizarPrestamo extends javax.swing.JFrame {

    Biblioteca biblioteca;
    PrestamoModel prestamo;
    ArrayList<String> IsbnLibros;
    public String documentoUsuario, IsbnLibro;
    public int librroId = 0;
    Cconexion conexion = new Cconexion();

    public FrmRealizarPrestamo(int idLibro) {
        initComponents();
        biblioteca = new Biblioteca();
        prestamo = new PrestamoModel();
        IsbnLibros = new ArrayList();
        IsbnLibros = biblioteca.obtenerLibroById(idLibro);
        librroId = idLibro;
        TxtDocumento.setText("");
        llenarComboCategoria();
        System.out.println("lista: " + IsbnLibros);
    }

    public void prestarLibro() {
        documentoUsuario = TxtDocumento.getText();
        IsbnLibro = (String) ComboIdLibro.getSelectedItem();
        Date fechaActual = new Date();

        if (documentoUsuario.isEmpty() || IsbnLibro.equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this, "Llene los datos correctamente para realizar el préstamo");
            return;
        }
        
        else
        {
            
        try {
            String SQLquery = "CALL verificar_usuario(?)";
            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
            ps.setString(1, documentoUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prestamo = new PrestamoModel(documentoUsuario, librroId, IsbnLibro, fechaActual, null);
                biblioteca.prestarLibro(prestamo);

                String actualizarEstadoSQL = "CALL actualizar_estado_ejemplar(?,?,?)";
                PreparedStatement psEstado = conexion.estableceConexcion().prepareStatement(actualizarEstadoSQL);
                psEstado.setString(1, IsbnLibro);
                psEstado.setDate(2, null);
                psEstado.setString(3, null);

                psEstado.executeUpdate();

                JOptionPane.showMessageDialog(this, "Préstamo realizado correctamente.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado, regístrese primero.");
            }

        } catch (Exception e) {
            System.out.println("No se pudo realizar el préstamo: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al realizar el préstamo.");
        }
            
        }

    }

    public void llenarComboCategoria() {

        ComboIdLibro.removeAllItems();
        ComboIdLibro.addItem("Seleccione...");
        try {

            for (int i = 0; i < IsbnLibros.size(); i++) {

                ComboIdLibro.addItem(IsbnLibros.get(i));
            }

        } catch (Exception e) {
            System.out.println("No se pudo traer las categorías: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnPrestarLibro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtDocumento = new javax.swing.JTextField();
        ComboIdLibro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BtnPrestarLibro.setBackground(new java.awt.Color(0, 204, 255));
        BtnPrestarLibro.setText("Prestar libro");
        BtnPrestarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrestarLibroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Escoga copia del libro");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingrese documento");

        TxtDocumento.setText("jTextField1");

        ComboIdLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(TxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(BtnPrestarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(BtnPrestarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPrestarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrestarLibroActionPerformed
        prestarLibro();
        
    }//GEN-LAST:event_BtnPrestarLibroActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRealizarPrestamo(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPrestarLibro;
    private javax.swing.JComboBox<String> ComboIdLibro;
    private javax.swing.JTextField TxtDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
