package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//FORMULARIO PRINCIAPAL DE LA VISTA ADMIN, EN EL CUAL AGREGAMOS LIBROS, PODEMOS MIRAR REPORTES, CAMBIAMOS EL ESTADO DE LOS EJEMPLARES.
public class FrmBiblioteca extends javax.swing.JFrame {

    FrmVentanaDeshabilitar v2;
    String titulo, autor, categoria;
    Date fechaPublicacion;
    Reportes reporteLibro;
    int stock;
    String[] encabezado = {"Id", "Titulo", "Autor", "categoria", "Fecha de pubicacion", "stock"};
    ArrayList<Libro> libroRecibido;
    Cconexion conexion = new Cconexion();
    private Biblioteca biblioteca;
    private Libro libro;

    public void setV2(FrmVentanaDeshabilitar v2) {
        this.v2 = v2;
    }

    public FrmBiblioteca() {
        initComponents();
        TxtAutorLibro.setText("");
        TxtTituloLibro.setText("");
        this.biblioteca = new Biblioteca();
        this.reporteLibro = new Reportes();
        this.libro = new Libro();
        this.libroRecibido = biblioteca.obtenerLibros();
        llenarComboCategoria();
        mostrarInfo();

    }
//FUNCION PARA LLENAR EL COMBO BOX DE LAS CATEGORIAS TOMANDO DIRECTAMENTE LA INFORMACION DE LA BASE DE DATOS
    public void llenarComboCategoria() {
        String SQLquery = "CALL mostrar_categoria()";
        comboCategoria.removeAllItems();
        comboCategoria.addItem("Seleccione...");

        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery); ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                String categoria = response.getString("nombre");
                comboCategoria.addItem(categoria);
            }

        } catch (Exception e) {
            System.out.println("No se pudo traer las categorías: " + e.getMessage());
        }
    }
//FUNCION PARA MOSTRAR LA INFORMACION DE LOS LIBROS QUE HAY EN LA BIBLIOTECA EN UNA TABLA
    public void mostrarInfo() {
        this.libroRecibido = biblioteca.obtenerLibros();
        try {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezado);
            for (int i = 0; i < libroRecibido.size(); i++) {
                modelo.addRow(new Object[]{
                    libroRecibido.get(i).getId(),
                    libroRecibido.get(i).getTitulo(),
                    libroRecibido.get(i).getAutor(),
                    libroRecibido.get(i).getCategoria(),
                    libroRecibido.get(i).getFechaPublicacion(),
                    libroRecibido.get(i).getStock()
                });

            }

            TableInfo.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar nada" + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
//LOGICA PARA AGREGAR UN LIBRO A LA BIBLIOTECA, VALIDANDO QUE SE REALIZE DE MANERA CORRECTA.
    public void guardarLibro() {
        titulo = TxtTituloLibro.getText();
        autor = TxtAutorLibro.getText();
        stock = ((Integer) SpinerStock.getValue()).intValue();
        categoria = (String) comboCategoria.getSelectedItem();
        Date fechaSeleccionada = CalendarFechaPublicacion.getDate();
        stock = Integer.parseInt(SpinerStock.getValue().toString());
        Date FechaActual = new Date();

        if (titulo.isEmpty() || autor.isEmpty() || categoria.equals("Seleccione...") || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Debes ingresar todos los datos.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (stock <= 0) {
            JOptionPane.showMessageDialog(this, "el stock no puede ser menor o igual a 0 .", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (fechaSeleccionada.after(FechaActual)) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una fecha valida.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            Libro nuevoLibro = new Libro(titulo, autor, categoria, fechaSeleccionada, stock);
            biblioteca.guardarLibro(nuevoLibro);
            JOptionPane.showMessageDialog(this, "Libro guardado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            TxtAutorLibro.setText("");
            TxtTituloLibro.setText("");
            comboCategoria.setSelectedIndex(0);
            SpinerStock.setValue(0);
            CalendarFechaPublicacion.setDate(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar nada: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TxtAutorLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtTituloLibro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BtnGuardar = new javax.swing.JButton();
        BtnDeshabilitar = new javax.swing.JButton();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        SpinerStock = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        BtnSalir = new javax.swing.JButton();
        CalendarFechaPublicacion = new com.toedter.calendar.JDateChooser();
        BtnVerReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        TableInfo.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Autor");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Titulo");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ingrese Categoria");

        BtnGuardar.setBackground(new java.awt.Color(0, 153, 255));
        BtnGuardar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BtnGuardar.setText("guardar libro");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnDeshabilitar.setBackground(new java.awt.Color(255, 0, 51));
        BtnDeshabilitar.setText("Deshabilitar libros --->");
        BtnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeshabilitarActionPerformed(evt);
            }
        });

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Stock");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha Publicacion");

        BtnSalir.setBackground(new java.awt.Color(255, 0, 51));
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnVerReportes.setBackground(new java.awt.Color(153, 0, 153));
        BtnVerReportes.setText("Ver Reportes");
        BtnVerReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(263, 263, 263)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtAutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(39, 39, 39)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(CalendarFechaPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(218, 218, 218)
                                        .addComponent(BtnVerReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SpinerStock, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalendarFechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtTituloLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpinerStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtAutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(BtnVerReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSalir))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        guardarLibro();
        mostrarInfo();

    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeshabilitarActionPerformed
        FrmVentanaDeshabilitar v2 = new FrmVentanaDeshabilitar();
        v2.setV1(this);
        v2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnDeshabilitarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        FrmLogin v3 = new FrmLogin();
        v3.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnVerReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerReportesActionPerformed
        FrmReportes reportes = new FrmReportes();
        reportes.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnVerReportesActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton BtnDeshabilitar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton BtnVerReportes;
    private com.toedter.calendar.JDateChooser CalendarFechaPublicacion;
    private javax.swing.JSpinner SpinerStock;
    private javax.swing.JTable TableInfo;
    private javax.swing.JTextField TxtAutorLibro;
    private javax.swing.JTextField TxtTituloLibro;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
