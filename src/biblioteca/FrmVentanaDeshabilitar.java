package biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sun.jvm.hotspot.HelloWorld.e;

/**
 *
 * @author Oscar
 */
public class FrmVentanaDeshabilitar extends javax.swing.JFrame {

    private FrmBiblioteca v1;
    private Biblioteca biblioteca;
    ArrayList<Libro> libroRecibido;
    String[] encabezado = {"ISBN", "Titulo", "Autor", "Fecha de publicacion"};
    Cconexion conexion = new Cconexion();

    public void setV1(FrmBiblioteca v1) {
        this.v1 = v1;
    }

    public FrmVentanaDeshabilitar() {

        initComponents();
        TxtBuscarTitulo.setText("");
        this.biblioteca = new Biblioteca();
        obtenerIsbn.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtBuscarTitulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        BtnVentanaBiblioteca = new javax.swing.JButton();
        BtnHabilitar = new javax.swing.JButton();
        BtnDeshabilitar = new javax.swing.JButton();
        obtenerIsbn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnDaniado = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jToggleButton1.setText("jToggleButton1");

        jToggleButton2.setText("jToggleButton2");

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar por titulo o autor");

        TableInfo.setBackground(new java.awt.Color(102, 102, 102));
        TableInfo.setForeground(new java.awt.Color(0, 0, 0));
        TableInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableInfo);

        BtnVentanaBiblioteca.setBackground(new java.awt.Color(0, 153, 255));
        BtnVentanaBiblioteca.setText("<-- Regrar a la biblioteca");
        BtnVentanaBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentanaBibliotecaActionPerformed(evt);
            }
        });

        BtnHabilitar.setBackground(new java.awt.Color(51, 204, 0));
        BtnHabilitar.setForeground(new java.awt.Color(255, 255, 255));
        BtnHabilitar.setText("Habilitar");
        BtnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHabilitarActionPerformed(evt);
            }
        });

        BtnDeshabilitar.setBackground(new java.awt.Color(255, 0, 51));
        BtnDeshabilitar.setText("Deshablitar");
        BtnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeshabilitarActionPerformed(evt);
            }
        });

        obtenerIsbn.setText("jTextField1");
        obtenerIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerIsbnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingrese ISBN del libro");

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnDaniado.setBackground(new java.awt.Color(255, 255, 0));
        btnDaniado.setForeground(new java.awt.Color(0, 0, 0));
        btnDaniado.setText("Libro Dañado");
        btnDaniado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaniadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVentanaBiblioteca)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(obtenerIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(BtnHabilitar)
                        .addGap(29, 29, 29)
                        .addComponent(BtnDeshabilitar))
                    .addComponent(TxtBuscarTitulo))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDaniado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtBuscarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnDeshabilitar)
                        .addComponent(BtnHabilitar)
                        .addComponent(btnDaniado))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(obtenerIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnVentanaBiblioteca)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarEjemplarPorTitulo() {
        String textoBuscado = TxtBuscarTitulo.getText().trim().toLowerCase();
        ArrayList<Ejemplares> ejemplaresFiltrados = new ArrayList<>();
        ArrayList<Ejemplares> todosLosEjemplares = new ArrayList<>(biblioteca.obtenerEstadoLibros());

        for (int i = 0; i < todosLosEjemplares.size(); i++) {
            Ejemplares ejemplar = todosLosEjemplares.get(i);
            String titulo = ejemplar.getTitulo().toLowerCase();
            String autor = ejemplar.getAutor().toLowerCase();

            if (titulo.contains(textoBuscado) || autor.contains(textoBuscado)) {
                ejemplaresFiltrados.add(ejemplar);
            }
        }

        String[] encabezado = {"ISBN", "Titulo", "Autor", "Fecha de Publicación", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(encabezado);

        for (int i = 0; i < ejemplaresFiltrados.size(); i++) {
            Ejemplares ejemplar = ejemplaresFiltrados.get(i);

            modelo.addRow(new Object[]{
                ejemplar.getISBN(),
                ejemplar.getTitulo(),
                ejemplar.getAutor(),
                ejemplar.getFechaPublicacion(),
                ejemplar.getEstado()
            });
        }

        TableInfo.setModel(modelo);
    }

    public void DeshabilitarLibros() {
        String ISBN = obtenerIsbn.getText().trim();

        if (ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean resultado = biblioteca.actualizarEstadoDeshabilitado(ISBN);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "El ejemplar fue deshabilitado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo deshabilitar el ejemplar. Verifique el ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void HabilitarLibros() {
    String ISBN = obtenerIsbn.getText().trim();

    if (ISBN.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean resultado = biblioteca.actualizarEstadoDisponible(ISBN);

    if (resultado) {
        JOptionPane.showMessageDialog(this, "El ejemplar fue habilitado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo habilitar el ejemplar. Verifique el ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    public void LibrosDañados() {
    String ISBN = obtenerIsbn.getText().trim();

    if (ISBN.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese un ISBN válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean resultado = biblioteca.actualizarEstadoDaniado(ISBN);

    if (resultado) {
        JOptionPane.showMessageDialog(this, "El ejemplar fue marcado como dañado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo marcar el ejemplar. Verifique el ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




    private void BtnVentanaBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentanaBibliotecaActionPerformed
        FrmBiblioteca v1 = new FrmBiblioteca();
        v1.setV2(this);
        v1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnVentanaBibliotecaActionPerformed

    private void BtnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHabilitarActionPerformed
   HabilitarLibros() ;

    }//GEN-LAST:event_BtnHabilitarActionPerformed

    private void BtnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeshabilitarActionPerformed
       DeshabilitarLibros();
    }//GEN-LAST:event_BtnDeshabilitarActionPerformed

    private void obtenerIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerIsbnActionPerformed
       
    }//GEN-LAST:event_obtenerIsbnActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEjemplarPorTitulo();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDaniadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaniadoActionPerformed
     LibrosDañados();
    }//GEN-LAST:event_btnDaniadoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaDeshabilitar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentanaDeshabilitar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeshabilitar;
    private javax.swing.JButton BtnHabilitar;
    private javax.swing.JButton BtnVentanaBiblioteca;
    private javax.swing.JTable TableInfo;
    private javax.swing.JTextField TxtBuscarTitulo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDaniado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField obtenerIsbn;
    // End of variables declaration//GEN-END:variables
}
