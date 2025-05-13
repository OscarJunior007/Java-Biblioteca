package biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmDefaullt extends javax.swing.JFrame {

    String[] encabezado = {"Id", "Titulo", "Autor", "Feca de pubicacion", "Seleccione"};
    ArrayList<Libro> libroRecibido;
    DefaultTableModel modelo = new DefaultTableModel();

    private Biblioteca biblioteca;
    private Libro libro;
    private int idLibro;

    public FrmDefaullt() {
        initComponents();
        this.biblioteca = new Biblioteca();
        this.libro = new Libro();
        this.libroRecibido = biblioteca.obtenerLibros();
        idLibro = 0;
        mostrarInfo();

    }

    public void recorrerTabla() {
        DefaultTableModel modelo = (DefaultTableModel) TableInfo.getModel();

        int librosSeleccionados = 0;
        int idSeleccionado = 0;

        try {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                boolean seleccion = (boolean) modelo.getValueAt(i, 4);

                if (seleccion) {
                    librosSeleccionados++;
                    idSeleccionado = (int) modelo.getValueAt(i, 0);
                }
            }

            if (librosSeleccionados == 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un libro para prestar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if (librosSeleccionados > 1) {
                JOptionPane.showMessageDialog(this, "Solo puede seleccionar un libro a la vez.", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                FrmRealizarPrestamo vPrestamo = new FrmRealizarPrestamo(idSeleccionado);
                vPrestamo.setVisible(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar nada" + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrarInfo() {
        this.libroRecibido = biblioteca.obtenerLibros();
        try {

            DefaultTableModel modelo = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 4;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 4) {
                        return Boolean.class;
                    }
                    return super.getColumnClass(columnIndex);
                }
            };

            modelo.setColumnIdentifiers(encabezado);
            for (int i = 0; i < libroRecibido.size(); i++) {
                modelo.addRow(new Object[]{
                    libroRecibido.get(i).getId(),
                    libroRecibido.get(i).getTitulo(),
                    libroRecibido.get(i).getAutor(),
                    libroRecibido.get(i).getFechaPublicacion(),
                    false

                });

            }

            modelo.addTableModelListener(e -> {

            });

            TableInfo.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar nada" + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void buscarLibroPorTitulo() {
        String textoBuscado = TxtBuscarTitulo.getText().trim().toLowerCase();
        ArrayList<Libro> librosFiltrados = new ArrayList<>();
        ArrayList<Libro> todosLosLibros = new ArrayList<>(biblioteca.obtenerLibros());

        for (int i = 0; i < todosLosLibros.size(); i++) {
            Libro libro = todosLosLibros.get(i);
            String titulo = libro.getTitulo().toLowerCase();
            String autor = libro.getAutor().toLowerCase();

            if (titulo.contains(textoBuscado) || autor.contains(textoBuscado)) {
                librosFiltrados.add(libro);
            }
        }

        try {
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 4;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return (columnIndex == 4) ? Boolean.class : super.getColumnClass(columnIndex);
                }
            };

            modelo.setColumnIdentifiers(encabezado);
            for (Libro libro : librosFiltrados) {
                modelo.addRow(new Object[]{
                    libro.getId(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getFechaPublicacion(),
                    false
                });
            }

            TableInfo.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar libros: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtBuscarTitulo = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInfo = new javax.swing.JTable();
        BtnPrestarLibro = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        BtnDevolverLibros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar por Titulo o Autor");

        TxtBuscarTitulo.setBackground(new java.awt.Color(51, 51, 51));
        TxtBuscarTitulo.setForeground(new java.awt.Color(255, 255, 255));

        BtnBuscar.setBackground(new java.awt.Color(0, 204, 255));
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        TableInfo.setAutoCreateRowSorter(true);
        TableInfo.setBackground(new java.awt.Color(255, 255, 255));
        TableInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        TableInfo.setForeground(new java.awt.Color(0, 0, 0));
        TableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableInfo.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(TableInfo);

        BtnPrestarLibro.setBackground(new java.awt.Color(0, 204, 255));
        BtnPrestarLibro.setText("Prestar");
        BtnPrestarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrestarLibroActionPerformed(evt);
            }
        });

        BtnSalir.setBackground(new java.awt.Color(255, 0, 51));
        BtnSalir.setText("SALIR");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnDevolverLibros.setBackground(new java.awt.Color(0, 204, 255));
        BtnDevolverLibros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnDevolverLibros.setText("Devolucion de libros");
        BtnDevolverLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDevolverLibrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtBuscarTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDevolverLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnPrestarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtBuscarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnPrestarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDevolverLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void BtnPrestarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrestarLibroActionPerformed

        recorrerTabla();
    }//GEN-LAST:event_BtnPrestarLibroActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        buscarLibroPorTitulo();

    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnDevolverLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDevolverLibrosActionPerformed
       FrmDevolverLibros devolver = new FrmDevolverLibros();
       devolver.setVisible(true);
       dispose();
    }//GEN-LAST:event_BtnDevolverLibrosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDefaullt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDefaullt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDefaullt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDefaullt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDefaullt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnDevolverLibros;
    private javax.swing.JButton BtnPrestarLibro;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTable TableInfo;
    private javax.swing.JTextField TxtBuscarTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
