package biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmReportes extends javax.swing.JFrame {
//FORMULARIO DONDE SE REALIZAN LOS REPORTES.
    Reportes reporteLibro;
    Cconexion conexion = new Cconexion();
    private Biblioteca biblioteca;
    private Libro libro;
    ArrayList<reporteInventarioModel> libroRecibido;
    ArrayList<PrestamoModel> prestamos;
    ArrayList<Libro> LibrosMasPrestados;

    public FrmReportes() {
        initComponents();
        reporteLibro = new Reportes();
        this.biblioteca = new Biblioteca();
        this.prestamos = new ArrayList();
        this.libroRecibido = new ArrayList();
        this.LibrosMasPrestados = biblioteca.librosMasPrestados();

    }
//LLAMADO DEL REPORTE DE INVENTARIO GENERAL
    public void ReporteInventario() {
        String[] encabezado = {"Titulo", "Autor", "categoria", "Fecha de pubicacion", "ISBN","Estado"};
        this.libroRecibido = biblioteca.reporteInventario();
        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezado);

            for (int i = 0; i < libroRecibido.size(); i++) {
                modelo.addRow(new Object[]{
            
                    libroRecibido.get(i).getTitulo(),
                    libroRecibido.get(i).getAutor(),
                    libroRecibido.get(i).getCategoria(),
                    libroRecibido.get(i).getFechaPublicacion(),
                    libroRecibido.get(i).getISBN(),
                    libroRecibido.get(i).getEstado(),


         
                });

            }

            TableInfoReportes.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo traer la informacion" + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
//LLAMADO DEL REPORTE DE LOS LIRBOS MAS PRESTADO
    public void LibrosMasPrestados() {
        String[] encabezado = {"Id del libro", "Titulo", "Veces Prestado"};
        this.LibrosMasPrestados = biblioteca.librosMasPrestados();
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezado);
            for (int i = 0; i < LibrosMasPrestados.size(); i++) {
                modelo.addRow(new Object[]{
                    LibrosMasPrestados.get(i).getId(),
                    LibrosMasPrestados.get(i).getTitulo(),
                    LibrosMasPrestados.get(i).getVecesPrestado(),});
                TableInfoReportes.setModel(modelo);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "No se pudo traer la informacion" + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
//LLAMADO DE TODOS LOS REPORTES DE LOS PRESTAMOS
    public void ReportePrestamosGeneral() {
        String[] encabezado = {"Documento del usuario", "Id del libro", "Id del ejemplar", "Fecha Prestamos", "Fecha Devolucion", "Estado"};
        this.prestamos.clear();
        this.prestamos = biblioteca.reporteTablePrestamos();
        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezado);

            for (int i = 0; i < prestamos.size(); i++) {
                modelo.addRow(new Object[]{
                    prestamos.get(i).getDocumentoUsuario(),
                    prestamos.get(i).getLibroId(),
                    prestamos.get(i).getIdEjemplar(),
                    prestamos.get(i).getFechaPrestamo(),
                    prestamos.get(i).getFechaDevolucion(),
                    prestamos.get(i).getEstado()
                });
            }

            TableInfoReportes.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo traer la información: " + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnReporteEstadistico = new javax.swing.JButton();
        BtnMasprestados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnReporteLibros1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtnReportePrestamosGeneral1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfoReportes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BtnReporteEstadistico.setBackground(new java.awt.Color(0, 204, 102));
        BtnReporteEstadistico.setText("Generar");
        BtnReporteEstadistico.setEnabled(false);
        BtnReporteEstadistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteEstadisticoActionPerformed(evt);
            }
        });

        BtnMasprestados.setBackground(new java.awt.Color(0, 204, 102));
        BtnMasprestados.setText("Generar");
        BtnMasprestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMasprestadosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Reporte inventario  biblioteca");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Reporte libros mas prestados");

        BtnVolver.setBackground(new java.awt.Color(51, 153, 255));
        BtnVolver.setText("Volver");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Reporte prestamos general");

        BtnReporteLibros1.setBackground(new java.awt.Color(0, 204, 102));
        BtnReporteLibros1.setText("Generar");
        BtnReporteLibros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteLibros1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Reporte estadistico");

        BtnReportePrestamosGeneral1.setBackground(new java.awt.Color(0, 204, 102));
        BtnReportePrestamosGeneral1.setText("Generar");
        BtnReportePrestamosGeneral1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportePrestamosGeneral1ActionPerformed(evt);
            }
        });

        TableInfoReportes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableInfoReportes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(BtnMasprestados, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(BtnReporteLibros1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(BtnReportePrestamosGeneral1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                                .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(BtnReporteEstadistico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReporteLibros1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReportePrestamosGeneral1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnMasprestados, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReporteEstadistico, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void BtnReporteEstadisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteEstadisticoActionPerformed
    }//GEN-LAST:event_BtnReporteEstadisticoActionPerformed

    private void BtnMasprestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMasprestadosActionPerformed
        LibrosMasPrestados();
        reporteLibro.exportarLibrosMasPrestados();
    }//GEN-LAST:event_BtnMasprestadosActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        FrmBiblioteca biblioteca = new FrmBiblioteca();
        biblioteca.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void BtnReporteLibros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteLibros1ActionPerformed
           ReporteInventario();
         reporteLibro.reporteLibrosExcel();    }//GEN-LAST:event_BtnReporteLibros1ActionPerformed

    private void BtnReportePrestamosGeneral1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportePrestamosGeneral1ActionPerformed
        ReportePrestamosGeneral();
        reporteLibro.exportInfoPrestamos();    }//GEN-LAST:event_BtnReportePrestamosGeneral1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnMasprestados;
    private javax.swing.JButton BtnReporteEstadistico;
    private javax.swing.JButton BtnReporteLibros1;
    private javax.swing.JButton BtnReportePrestamosGeneral1;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTable TableInfoReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
